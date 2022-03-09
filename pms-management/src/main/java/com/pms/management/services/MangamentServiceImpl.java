package com.pms.management.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


import com.pms.management.PmsManagementApplication;
import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.UserConverter;
import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.UserDetailsViewDto;
import com.pms.management.dto.UserDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.repository.ManagementRepository;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.MailService;

import net.bytebuddy.utility.RandomString;

public class MangamentServiceImpl implements ManagementService {

	@Autowired
	private ManagementRepository repository;

	@Autowired
	private MailService mailService;

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	RestTemplate restTemplate = new RestTemplate();


	/**
	 * Patient self Registration
	 * 
	 */
	@Override
	public UserDto saveUser(UserDto userDto) throws CustomException {

		if (repository.findByEmailId(userDto.getEmailId()).isPresent()) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Email id already exist");
		}
		try {
			UserEntity userEntity = userConverter.toEntity(userDto);
			userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userEntity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			userEntity.setCreatedDate(new Date());
			UserEntity saveUser = repository.save(userEntity);
			/**
			 * Saving user in Keyclock Server with Properties username(emailid) and password
			 */
			this.saveUserInKeyclock(userDto.getEmailId(), userDto.getPassword());

			mailService.sendMail(saveUser);
			return userConverter.toDto(saveUser);
		} catch (Exception ex) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Issue while creating user");
		}
	}

	@Override
	public UserDto addUser(UserDto userDto) throws CustomException {

		if (repository.findByEmailId(userDto.getEmailId()).isPresent()) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Email id already exist");
		}
		try {
			UserEntity userEntity = userConverter.toEntity(userDto);
			String default_password = "Password@123";
			userDto.setPassword(default_password);
			// userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userEntity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			userEntity.setCreatedBy(1l);
			userEntity.setCreatedDate(new Date());
			UserEntity saveUser = repository.save(userEntity);
			mailService.sendMailToNewUser(saveUser, default_password);
			return userConverter.toDto(saveUser);
		} catch (Exception ex) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Issue while creating user");
		}
	}

	@Override
	public List<UserEntity> getPatients() {
		List<UserEntity> patients = repository.findAll();
		return patients.stream().filter(p -> p.getRoleId() == 5).collect(Collectors.toList());
	}

	@Override
	public List<UserEntity> getHospitalUsers() {

		List<UserEntity> patients = repository.findAll();
		return patients.stream().filter(p -> p.getRoleId() == 3 || p.getRoleId() == 4).collect(Collectors.toList());
	}

	@Override
	public UserEntity updateStatus(UserDto user) {
		if (repository.findByUserId(user.getUserId()).isPresent()) {

			UserEntity entity = repository.findByUserId(user.getUserId()).get();
			entity.setActiveStatus(user.getActive());

			this.sendMailForUpdateStatus(entity);
			return repository.save(entity);
		}

		return null;
	}

	@Override
	public UserDetailsViewDto findByEmailId(String emailId) throws CustomException {
		Optional<UserEntity> optional = repository.findByEmailId(emailId);
		if (optional.isPresent()) {
			UserEntity user = optional.get();
			return new UserDetailsViewDto(userConverter.toDto(user));
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, "Email id does not exist");
		}
	}
	/**
	 * Patient Update Password
	 */

	@Override
	public UserDetailsViewDto updatePassword(ChangePasswordDto dto) throws CustomException {
		Optional<UserEntity> optional = repository.findByEmailId(dto.getEmailId());
		if (optional.isPresent()) {
			UserEntity user = optional.get();
			if (pwdEncoder.matches(dto.getOldPassword(), user.getPassword())) {
				user.setPassword(pwdEncoder.encode(dto.getNewPassword()));
				user.setUpdatedDate(new Date());
				UserEntity saveUser = repository.save(user);
				this.updateUserPasswordInKeyclock(dto.getEmailId(), dto.getNewPassword());
				return new UserDetailsViewDto(userConverter.toDto(saveUser));
			} else {
				throw new CustomException(HttpStatus.NOT_FOUND, "Invalid password");
			}
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, "Invalid email id");
		}
	}

	public UserEntity findByUserId(Long userId) throws CustomException {
		Optional<UserEntity> optional = repository.findById(userId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, "User detail does not exits");
		}
	}

	private void generateOneTimePassword(UserEntity user) {
		UserEntity userEntity = repository.findByEmailId(user.getEmailId()).get();
		String otp = RandomString.make(8);
		String encodedOTP = pwdEncoder.encode(otp);
		userEntity.setPassword(encodedOTP);
		userEntity.setOtpRequestedTime(new Date());
		repository.save(userEntity);
		mailService.sendMailToActiveUser(userEntity, otp);
	}

	private void sendMailForUpdateStatus(UserEntity user) {
		String status = "";
		if (user.getActiveStatus() == 1) {
			this.generateOneTimePassword(user);
			return;
		} else if (user.getActiveStatus() == 2) {
			status = "In-Active";
		} else {
			status = "Blocked";
		}

		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<p> Welcome to the PMS Application : </br>" + user.getTitle() + " " + user.getFirstName() + " "
				+ user.getLastName() + " your profile status is updated : </p>" + "<h3> <b>" + status + " </b></h3>"
				+ "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient, subject, message);
	}
	
	public void saveUserInKeyclock(String username, String password) {

		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id", "login-ms");
			requestParams.add("username", "ankit");
			requestParams.add("password", "ankit");
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", "b2dabfcf-e66a-47bc-b3c3-892071c29f1e");
			requestParams.add("scope", "openid");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
			AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);
			String token_admin = keycloakAccessToken.getToken().trim();

			String url_register = "http://localhost:8180/auth/admin/realms/pms/users";
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "password");
			jsonObj.put("value", password);

			JSONArray credentials = new JSONArray();
			credentials.put(jsonObj);
			JSONObject userParam = new JSONObject();
			userParam.put("username", username);
			userParam.put("credentials", credentials);
			userParam.put("enabled", "true");
			userParam.put("emailVerified", "true");

			HttpHeaders headers_user = new HttpHeaders();
			headers_user.setContentType(MediaType.APPLICATION_JSON);
			headers_user.add("Authorization", "Bearer " + token_admin);
			HttpEntity<String> request_user = new HttpEntity<String>(userParam.toString(), headers_user);
			ResponseEntity resp = restTemplate.postForEntity(url_register, request_user, String.class);

			/**
			 * User id
			 */
			String url_userid = "http://localhost:8180/auth/admin/realms/pms/users/?username=" + username;
			HttpHeaders headers_userid = new HttpHeaders();
			headers_userid.setContentType(MediaType.APPLICATION_JSON);
			headers_userid.add("Authorization", "Bearer " + token_admin);
			HttpEntity<String> request_userid = new HttpEntity<String>(headers_userid);
			ResponseEntity resp_userid = restTemplate.exchange(url_userid,HttpMethod.GET ,request_userid, String.class);	
			JSONArray userid_json= new JSONArray(resp_userid.getBody().toString());
			
			/**
			 * Role Mapping
			 */
			String url_role="http://localhost:8180/auth/admin/realms/pms/users/"+userid_json.getJSONObject(0).get("id")+"/role-mappings/realm";
			HttpHeaders headers_role = new HttpHeaders();
			headers_role.setContentType(MediaType.APPLICATION_JSON);
			headers_role.add("Authorization", "Bearer " + token_admin);
			
			JSONObject roleParam = new JSONObject();
			roleParam.put("id", "397e835f-06e6-4610-82eb-b461be517b69");
			roleParam.put("name", "patient");
			
			JSONArray roleArray = new JSONArray();
			roleArray.put(roleParam);

			
			HttpEntity<String> request_role = new HttpEntity<String>(roleArray.toString(),headers_role);
			ResponseEntity resp_role = restTemplate.exchange(url_role,HttpMethod.POST ,request_role, String.class);	
//			System.out.println(resp_role.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void updateUserPasswordInKeyclock(String username, String password) {

//		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id", "login-ms");
			requestParams.add("username", "ankit");
			requestParams.add("password", "ankit");
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", "b2dabfcf-e66a-47bc-b3c3-892071c29f1e");
			requestParams.add("scope", "openid");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
			AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);
			String token_admin = keycloakAccessToken.getToken().trim();

			
			/**
			 * User id
			 */
			String url_userid = "http://localhost:8180/auth/admin/realms/pms/users/?username=" + username;
			HttpHeaders headers_userid = new HttpHeaders();
			headers_userid.setContentType(MediaType.APPLICATION_JSON);
			headers_userid.add("Authorization", "Bearer " + token_admin);
			HttpEntity<String> request_userid = new HttpEntity<String>(headers_userid);
			ResponseEntity resp_userid = restTemplate.exchange(url_userid,HttpMethod.GET ,request_userid, String.class);	
			JSONArray userid_json= new JSONArray(resp_userid.getBody().toString());
			
			/**
			 * Update Password
			 */
			String url_updatepwd="http://localhost:8180/auth/admin/realms/pms/users/"+userid_json.getJSONObject(0).get("id")+"/reset-password";
			HttpHeaders headers_updatepwd = new HttpHeaders();
			headers_updatepwd.setContentType(MediaType.APPLICATION_JSON);
			headers_updatepwd.add("Authorization", "Bearer " + token_admin);
			
			JSONObject updatepwdParam = new JSONObject();
			updatepwdParam.put("type", "password");
			updatepwdParam.put("temporary", "false");
			updatepwdParam.put("value", password);
			
//			JSONArray updatepwdArray = new JSONArray();
//			updatepwdArray.put(updatepwdParam);

			System.out.println(updatepwdParam);
			HttpEntity<String> request_updatepwd = new HttpEntity<String>(updatepwdParam.toString(),headers_updatepwd);
			ResponseEntity resp_updatepwd = restTemplate.exchange(url_updatepwd,HttpMethod.PUT ,request_updatepwd, String.class);	
			System.out.println(resp_updatepwd.getBody());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}


	private AccessTokenResponse getAccessTokenResponse(HttpEntity<MultiValueMap<String, String>> request, String url) {
		try {
			ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request,
					AccessTokenResponse.class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			try {
				ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request,
						AccessTokenResponse.class);
				return response.getBody();
			} catch (Exception ex) {
				throw ex;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	
}
