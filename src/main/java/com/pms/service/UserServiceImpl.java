package com.pms.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.ResponseUtil;
import com.pms.entity.UserEntity;
import com.pms.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	 @Autowired
	 private BCryptPasswordEncoder pwdEncoder;


	//@Override

//	public ResponseEntity<ApiResponse> validateUser(String name, String password) {
//		Optional<UserEntity> optional = userRepo.findByFirstNameAndPassword(name, password);
//	}
	public ResponseEntity<ApiResponse> getUserById(Integer id) {
		Optional<UserEntity> optional = repository.findByUserId(id);

		UserEntity user = null;
		if (optional.isPresent()) {
			user = optional.get();
			return ResponseUtil.getResponse(HttpStatus.OK,"Login Successful",user);
		
		}
		else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, "Login Failed",null);
		
		}
	}
//-------------WITH SECURITY---------------------------------------------------------------------------------------------//
	@Override
	public ResponseEntity<ApiResponse> saveUser(UserEntity user) {
		user.setPassword(
				pwdEncoder.encode
				  (user.getPassword())
				);
		return   ResponseUtil.getResponse(HttpStatus.OK,"user registered Successfully",repository.save(user).getUserId());  
	}
	
	@Override
	public ResponseEntity<ApiResponse> findByEmailId(String emailId) {
		
		return  ResponseUtil.getResponse(HttpStatus.OK,"Login Successful",repository.findByEmailId(emailId));         
	}
	
	//By using Api Response//


	/*
	 * 
	 * @Override
	public ResponseEntity<ApiResponse> findByEmailId(String emailId) {
		 
		Optional<UserEntity> optional = repository.findByEmailId(emailId);
		UserEntity user = null;
		   if(optional.isPresent()){
			   user = optional.get();
			   return ResponseUtil.getResponse(HttpStatus.OK,"Login Successful",user);
		   }
		   else 
				return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, "Login Failed",null);
			
			
	}
	 * 
	 * 	
	*/	
	
	@Override
	public UserDetails loadUserByUsername(String emailId)
			throws UsernameNotFoundException {
		  Optional<UserEntity> optional=repository.findByEmailId(emailId);
		  
		 
		  
		  if(optional.isEmpty())
			  throw new UsernameNotFoundException("Email ID dose not exist");
		  
		  //read user form DB
		  UserEntity user=optional.get();
		return new org.springframework.security.core.userdetails.User(
				emailId,
				user.getPassword(),
				user.getRoles().stream()
			   .map(role->new SimpleGrantedAuthority(role))
			   .collect(Collectors.toList())
			 );
	}
	
	
	
    

}
