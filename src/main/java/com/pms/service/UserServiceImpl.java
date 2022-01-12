package com.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.ResponseUtil;
import com.pms.entity.UserEntity;
import com.pms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public ResponseEntity<ApiResponse> validateUser(String name, String password) {
		Optional<UserEntity> optional = userRepo.findByFirstNameAndPassword(name, password);
		UserEntity user = null;
		if (optional.isPresent()) {
			user = optional.get();
			return ResponseUtil.getResponse(HttpStatus.OK,"Login Successful",user);
		
		}
		else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, "Login Failed",null);
		
		}
	}

	

}
