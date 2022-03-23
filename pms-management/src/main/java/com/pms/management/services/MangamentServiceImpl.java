package com.pms.management.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.UserConverter;
import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.IdAndNameDto;
import com.pms.management.dto.UserDetailsViewDto;
import com.pms.management.dto.UserDto;
import com.pms.management.dto.UserViewDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.repository.ManagementRepository;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.KeyCloakService;
import com.pms.management.utils.MailService;
import com.pms.management.utils.PmsManagementUtil;

import net.bytebuddy.utility.RandomString;

@Service
public class MangamentServiceImpl implements ManagementService {

	@Autowired
	private ManagementRepository repository;

	@Autowired
	private MailService mailService;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private KeyCloakService keyCloakService;

	private String user_role;

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
			userEntity.setCreatedBy(1l);
			UserEntity saveUser = repository.save(userEntity);
			/**
			 * Saving user in Keyclock Server with Properties username(emailid) and password
			 */
			keyCloakService.saveUserInKeyclock(userDto.getEmailId(), userDto.getPassword());
//			mailService.sendMail(saveUser);
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
			/*
			 * Assigning employee id based on role ;
			 */
			if (userEntity.getRoleId() == 2) {
				this.user_role = "AD";
			} else if (userEntity.getRoleId() == 3) {
				this.user_role = "DR";
			} else {
				this.user_role = "NR";
			}
			userEntity.setEmployeeId(this.generateEmployeeId(user_role));
			String default_password = "Password@123";
			userDto.setPassword(default_password);
			userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userEntity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			userEntity.setCreatedBy(1l);
			userEntity.setCreatedDate(new Date());
			/**
			 * Register in KeyClock
			 */
			keyCloakService.addUserInKeyclock(userDto, default_password);

			UserEntity saveUser = repository.save(userEntity);
//			mailService.sendMailToNewUser(saveUser, default_password);
			return userConverter.toDto(saveUser);
		} catch (Exception ex) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Issue while creating user");
		}
	}

	@Override
	public List<UserViewDto> getPatients() {
		List<UserEntity> patients = repository.findAll();
		List<UserEntity> entities = patients.stream().filter(p -> p.getRoleId() == 5).collect(Collectors.toList());
		List<UserViewDto> filteredUsers = entities.stream().map(u -> {
			UserViewDto data = new UserViewDto(u.getUserId(), u.getTitle(), u.getFirstName(), u.getLastName(),
					u.getEmailId(), u.getDob(), u.getRoleId(), u.getEmployeeId(), u.getContactNo(), u.getPassword(),
					u.getActiveStatus(), u.getCreatedDate());
			return data;
		}).collect(Collectors.toList());
		return filteredUsers;
	}

	@Override
	public List<UserViewDto> getHospitalUsers() {

		List<UserEntity> patients = repository.findAll().stream().filter(p -> p.getRoleId() == 3 || p.getRoleId() == 4)
				.collect(Collectors.toList());
		List<UserViewDto> filteredUsers = patients.stream().map(u -> {
			UserViewDto data = new UserViewDto(u.getUserId(), u.getTitle(), u.getFirstName(), u.getLastName(),
					u.getEmailId(), u.getDob(), u.getRoleId(), u.getEmployeeId(), u.getContactNo(), u.getPassword(),
					u.getActiveStatus(), u.getCreatedDate());
			return data;
		}).collect(Collectors.toList());
		return filteredUsers;
	}

	@Override
	public UserDto updateStatus(UserDto user) {
		Optional<UserEntity> optional = repository.findByUserId(user.getUserId());
		if (optional.isPresent()) {

			UserEntity entity = optional.get();
			entity.setActiveStatus(user.getActive());

			this.sendMailForUpdateStatus(entity);
			return userConverter.toDto(repository.save(entity));
		}

		return null;
	}

	@Override
	public UserDto updateUserDetails(UserDto user) {
		Optional<UserEntity> optional = repository.findByUserId(user.getUserId());
		if (optional.isPresent()) {

			UserEntity entity = optional.get();
			entity.setTitle(user.getTitle());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());

			return userConverter.toDto(repository.save(entity));
		}

		return null;
	}

	@Override
	public UserDetailsViewDto findByEmailId(String emailId) throws CustomException {
		Optional<UserEntity> optional = repository.findByEmailId(emailId);
		if (optional.isPresent()) {
			UserEntity user = optional.get();
			if(user.getActiveStatus()!=1) {
				throw new CustomException(HttpStatus.NOT_FOUND, "Unauthorised User");
			}
			else {
				return new UserDetailsViewDto(userConverter.toDto(user));
			}
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, "Email id does not exist");
		}
	}

	/**
	 * Update Password
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
				keyCloakService.updateUserPasswordInKeyclock(dto.getEmailId(), dto.getNewPassword());
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

	private String generateEmployeeId(String role) {
		int min = 1000;
		int max = 9999;
		int randomNumber = (min + (int) (Math.random() * (max - min)));
		return role + randomNumber;
	}

	private void generateOneTimePassword(UserEntity user) {
		Optional<UserEntity> optional = repository.findByEmailId(user.getEmailId());
		if(optional.isPresent()) {
			UserEntity userEntity = optional.get();
			String default_password="Password@123";
			String encodedOTP = pwdEncoder.encode(default_password);
			userEntity.setPassword(encodedOTP);
			userEntity.setOtpRequestedTime(new Date());
			repository.save(userEntity);
//			mailService.sendMailToActiveUser(userEntity, default_password);
		}
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
//		mailService.sendMail(recipient, subject, message);
	}

	/**
	 * Data for Admin Dashboard
	 */
	public List<IdAndNameDto> monthWiseData() {
		List<Object[]> list = repository.getMonthWiseRegistrationCount();
		return list.stream().map(obj -> {
			return new IdAndNameDto(PmsManagementUtil.convertObjectIntoLong(obj[0]),
					PmsManagementUtil.convertObjectIntoString(obj[1]));
		}).collect(Collectors.toList());
	}

	@Override
	public UserDto forgotPassword(String emailId) throws CustomException {
		Optional<UserEntity> optional = repository.findByEmailId(emailId);
		if(optional.isPresent()) {
			UserEntity userEntity = optional.get();
			String default_password = "Password@123";
			userEntity.setPassword(pwdEncoder.encode(default_password));
			UserEntity saveUser = repository.save(userEntity);
//			mailService.sendMailToForgotPasswordUser(saveUser, default_password);
			return userConverter.toDto(saveUser);
		}
		else {
			throw new CustomException(HttpStatus.NOT_FOUND, "User detail does not exits");
		}
	}
	
	
}
