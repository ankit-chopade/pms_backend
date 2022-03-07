package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.exception.CustomException;
import com.pms.common.util.PmsUrlConstants;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.ChangePasswordDto;
import com.pms.dto.LoginDto;
import com.pms.dto.UserDto;
import com.pms.dto.UserTokenDto;
import com.pms.service.UserService;
import com.pms.util.TokenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	TokenService tokenService;
	@PostMapping(PmsUrlConstants.URL_REGISTRATION)
	public ResponseEntity<ApiResponse> saveUser(@RequestBody UserDto user) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "User registered successfully", this.service.saveUser(user));
	}

	@PostMapping(PmsUrlConstants.URL_LOGIN)
	public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDto loginDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Token generated successfully ",
				new UserTokenDto(service.findByEmailId(loginDto.getEmailId()),
						tokenService.generateTokens(loginDto.getEmailId(), loginDto.getPassword())));
	}


	@PostMapping(PmsUrlConstants.URL_CHANGE_PASSWORD)
	public ResponseEntity<ApiResponse> updatePassword(@RequestBody ChangePasswordDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Token generated successfully ", service.updatePassword(dto));
	}
}
