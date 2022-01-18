package com.pms.service;


import org.springframework.http.ResponseEntity;

import com.pms.common.entity.ApiResponse;
import com.pms.entity.UserEntity;


public interface UserService {
		

	public ResponseEntity<ApiResponse> getUserById(Integer id);
    
	public ResponseEntity<ApiResponse> saveUser(UserEntity user);
	
	public ResponseEntity<ApiResponse> findByEmailId(String emailId);
}
