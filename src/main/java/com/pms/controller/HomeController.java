package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.exception.CustomException;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.LoginDto;
import com.pms.entity.UserEntity;
import com.pms.service.UserService;
import com.pms.util.TokenService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")

public class HomeController {

	@Autowired
	UserService service;

	@Autowired
	private TokenService tokenService;


	@PostMapping("/registration")
	public ResponseEntity<ApiResponse> registerEmp(@RequestBody UserEntity user) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "registration completed Successfully ",
				this.service.saveUser(user));
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDto loginDto) {
		UserEntity user = this.service.findByEmailId(loginDto.getEmailId());
		return ResponseUtil.getResponse(HttpStatus.OK, "token generated Successfully ",
				this.tokenService.generateTokens(user,loginDto.getPassword()));
	}

	

	
}
