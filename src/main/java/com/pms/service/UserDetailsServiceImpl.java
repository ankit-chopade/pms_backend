package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.entity.UserEntity;
import com.pms.repository.UserRepository;

@Service
public class UserDetailsServiceImpl {
    
	@Autowired
    private	UserRepository repository;
	
//	
//	  @Override public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{ 
//		  UserEntity user= repository.findByEmailId(username);
//		  if(user == null) { 
//	       System.out.println("user not found ");
//	        throw new UsernameNotFoundException("user not found !"); 
//	       } return user; 
//	   }
	 
     

}
