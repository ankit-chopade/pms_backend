package com.pms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.common.exception.CustomException;
import com.pms.common.util.ErrorResponse;
import com.pms.entity.PatientEntity;
import com.pms.entity.RoleEntity;
import com.pms.entity.UserEntity;
import com.pms.repository.PatientRepository;
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
	private PatientRepository patientRepo;
	
	@Override
	public UserEntity saveUser(UserEntity user) throws CustomException {
		try {
			user.setPassword(pwdEncoder.encode(user.getPassword()));
			UserEntity saveUser = repository.save(user);
			   PatientEntity entity=new PatientEntity(user.getTitle(),user.getFirstName(),user.getLastName(),user.getDob(),
					   user.getEmailId()  , user.getContactNo());
			   patientRepo.save(entity);
			/**
			 * Patient Reg 
			 */
			this.sendMail(saveUser);
			return saveUser;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.RECORDNOTFOUND);
		}
	}

	@Override
	public UserEntity findByEmailId(String emailId) {
		Optional<UserEntity> optional = repository.findByEmailId(emailId);
		if (!optional.isPresent())
			throw new UsernameNotFoundException("Email ID dose not exist");
		UserEntity user = optional.get();
		return user;
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

}
