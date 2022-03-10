package com.pms.management.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.pms.management.dto.UserDto;

@Service
public class KeyCloakService {
	
	@Autowired
	RestTemplate restTemplate ;
	
	@Value("${mykeycloak.clientid}")
	private String clientId;
	
	@Value("${mykeycloak.clientsecret}")
	private String clientSecret;
	
	@Value("${mykeycloak.admin.username}")
	private String adminUsername;
	
	@Value("${mykeycloak.admin.password}")
	private String adminPassword;
	
	@Value("${mykeycloak.patient.id}")
	private String patientId;
	
	@Value("${mykeycloak.physician.id}")
	private String physicianId;
	
	@Value("${mykeycloak.nurse.id}")
	private String nurseId;
	
	@Value("${mykeycloak.admin.id}")
	private String adminId;
	
	public void saveUserInKeyclock(String username, String password) {

		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id",clientId);
			requestParams.add("username", adminUsername);
			requestParams.add("password", adminPassword);
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", clientSecret);
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
			ResponseEntity resp_userid = restTemplate.exchange(url_userid, HttpMethod.GET, request_userid,
					String.class);
			JSONArray userid_json = new JSONArray(resp_userid.getBody().toString());

			/**
			 * Role Mapping
			 */
			String url_role = "http://localhost:8180/auth/admin/realms/pms/users/"
					+ userid_json.getJSONObject(0).get("id") + "/role-mappings/realm";
			HttpHeaders headers_role = new HttpHeaders();
			headers_role.setContentType(MediaType.APPLICATION_JSON);
			headers_role.add("Authorization", "Bearer " + token_admin);

			JSONObject roleParam = new JSONObject();
			roleParam.put("id", patientId);
			roleParam.put("name", "patient");

			JSONArray roleArray = new JSONArray();
			roleArray.put(roleParam);

			HttpEntity<String> request_role = new HttpEntity<String>(roleArray.toString(), headers_role);
			ResponseEntity resp_role = restTemplate.exchange(url_role, HttpMethod.POST, request_role, String.class);
//			System.out.println(resp_role.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void addUserInKeyclock(UserDto dto, String password) {
		String username = dto.getEmailId();

		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id", clientId);
			requestParams.add("username", adminUsername);
			requestParams.add("password", adminPassword);
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", clientSecret);
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
			ResponseEntity resp_userid = restTemplate.exchange(url_userid, HttpMethod.GET, request_userid,
					String.class);
			JSONArray userid_json = new JSONArray(resp_userid.getBody().toString());

			/**
			 * Role Mapping
			 */
			String url_role = "http://localhost:8180/auth/admin/realms/pms/users/"+ userid_json.getJSONObject(0).get("id") + "/role-mappings/realm";
			HttpHeaders headers_role = new HttpHeaders();
			headers_role.setContentType(MediaType.APPLICATION_JSON);
			headers_role.add("Authorization", "Bearer " + token_admin);

			/**
			 * Checking for Nurse or Physician
			 */
			JSONObject roleParam = new JSONObject();
			if(dto.getRoleId()==3) {
				/**
				 * Physician
				 */
				roleParam.put("id",physicianId );
				roleParam.put("name", "physician");	
			}
			
			else if(dto.getRoleId()==4) {
				/**
				 * Nurse
				 */
				roleParam.put("id", nurseId);
				roleParam.put("name", "nurse");	
			}
			
			else if(dto.getRoleId()==2) {
				/**
				 * Admin
				 */
				roleParam.put("id", adminId);
				roleParam.put("name", "admin");	
			}
			
			

			JSONArray roleArray = new JSONArray();
			roleArray.put(roleParam);

			HttpEntity<String> request_role = new HttpEntity<String>(roleArray.toString(), headers_role);
			ResponseEntity resp_role = restTemplate.exchange(url_role, HttpMethod.POST, request_role, String.class);
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
		requestParams.add("client_id", clientId);
		requestParams.add("username", adminUsername);
		requestParams.add("password", adminPassword);
		requestParams.add("grant_type", "password");
		requestParams.add("client_secret", clientSecret);
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
		ResponseEntity resp_userid = restTemplate.exchange(url_userid, HttpMethod.GET, request_userid, String.class);
		JSONArray userid_json = new JSONArray(resp_userid.getBody().toString());

		/**
		 * Update Password
		 */
		String url_updatepwd = "http://localhost:8180/auth/admin/realms/pms/users/"
				+ userid_json.getJSONObject(0).get("id") + "/reset-password";
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
		HttpEntity<String> request_updatepwd = new HttpEntity<String>(updatepwdParam.toString(), headers_updatepwd);
		ResponseEntity resp_updatepwd = restTemplate.exchange(url_updatepwd, HttpMethod.PUT, request_updatepwd,
				String.class);
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
