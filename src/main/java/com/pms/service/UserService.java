package com.pms.service;

import org.springframework.http.ResponseEntity;

import com.pms.common.entity.ApiResponse;

public interface UserService {
	
	public  ResponseEntity<ApiResponse>  validateUser(String name,String password);
	

}
