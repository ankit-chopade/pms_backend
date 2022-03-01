package com.pms.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.common.exception.CustomException;
import com.pms.common.util.PmsConstant;
import com.pms.converter.UserConverter;
import com.pms.dto.ChangePasswordDto;
import com.pms.dto.UserDetailsViewDto;
import com.pms.dto.UserDto;
import com.pms.entity.RoleEntity;
import com.pms.entity.UserEntity;
import com.pms.repository.RoleRepository;
import com.pms.repository.UserRepository;
import com.pms.util.MailService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Autowired
	private MailService mailService;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDto saveUser(UserDto userDto) throws CustomException {

		if (repository.findByEmailId(userDto.getEmailId()).isPresent()) {
			throw new CustomException(HttpStatus.NOT_FOUND, "Email id already exist");
		}
		try {
			UserEntity userEntity = userConverter.toEntity(userDto);
			userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userEntity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
			userEntity.setCreatedDate(new Date());
			UserEntity saveUser = repository.save(userEntity);
			this.sendMail(saveUser);
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
			String password = "Password@123";
			userDto.setPassword(password);
			userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userEntity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
			userEntity.setCreatedBy(1l);
			userEntity.setCreatedDate(new Date());
			UserEntity saveUser = repository.save(userEntity);
			this.sendMailToNewUser(saveUser); 
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

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Optional<UserEntity> optional = repository.findByEmailId(emailId);

		if (!optional.isPresent())
			throw new UsernameNotFoundException("Email ID dose not exist");

		UserEntity user = optional.get();
		Set<String> roles = new HashSet<String>();
		RoleEntity roleEntity = roleRepository.findByRoleId(user.getRoleId());
		roles.add(roleEntity.getRoleName());
		return new User(emailId, user.getPassword(),
				roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
	}

	@Override
	public UserDetailsViewDto updatePassword(ChangePasswordDto dto) throws CustomException {
		Optional<UserEntity> optional = repository.findByEmailId(dto.getEmailId());
		if (optional.isPresent()) {
			UserEntity user = optional.get();
			if (pwdEncoder.matches(dto.getOldPassword(), user.getPassword())) {
				user.setPassword(pwdEncoder.encode(dto.getNewPassword()));
				user.setUpdatedDate(new Date());
				UserEntity updatedUser = repository.save(user)
						;
				this.sendMailForUpdateStatus(updatedUser);
				return new UserDetailsViewDto(userConverter.toDto(updatedUser));
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
			throw new CustomException(HttpStatus.NOT_FOUND, "User detail dosnot exits");
		}
	}
	
	private void sendMailForUpdateStatus(UserEntity user) {
		String status= "";
		if (user.getActiveStatus() == 1) {
			status = "Activated";
		} else if (user.getActiveStatus() == 2) {
			status = "In-Active";
		} else {
			status = "Blocked";
		}
		
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<p> Welcome to the PMS Application : </br>"				
				+user.getTitle()+ " " + user.getFirstName()+ " " + user.getLastName()
				+" your profile status is updated : </p>" + "<h3> <b>" + status +" </b></h3>"				
				+ "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient, subject, message);
	}

	private void sendMail(UserEntity user) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>Welcome to the PMS Application.</h2><hr>" + "<h3> Hello " + user.getTitle() + " "
				+ user.getFirstName() + " " + user.getLastName() + "</h3> </br>"
				+ "<p> Welcome to the PMS Application : </br>" + "your registration has been successfully completed."
				+ "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient, subject, message);
	}

	private void sendMailToNewUser(UserEntity user) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>Welcome to the PMS Application.</h2><hr>" + "<h3> Hello " + user.getTitle() + " "
				+ user.getFirstName() + " " + user.getLastName() + "</h3> </br>"
				+ "<p> Welcome to the PMS Application : </br>"
				+ "your registration has been successfully completed.</p>" + "<h3>your username : " + user.getEmailId()
				+ " </h3>" + "<h3>your default password : " + user.getPassword() + " </h3>"
				+ "this is one time login password please change your password." + "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient, subject, message);
	}

}
