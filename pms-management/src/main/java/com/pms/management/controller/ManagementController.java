package com.pms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.management.constants.ManagementConstants;
import com.pms.management.constants.ManagementUrlConstants;
import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.EmailIdDto;
import com.pms.management.dto.LoginDto;
import com.pms.management.dto.UserDto;
import com.pms.management.dto.UserTokenDto;
import com.pms.management.services.ManagementService;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.ResponseUtil;
import com.pms.management.utils.TokenService;

@RestController
@CrossOrigin(origins = ManagementConstants.PMS_CROSS_ORIGIN)
@RequestMapping(ManagementUrlConstants.URL_ROOT)
public class ManagementController {

	@Autowired
	private ManagementService service;

	@Autowired
	private TokenService tokenService;

	@PostMapping(ManagementUrlConstants.URL_REGISTRATION)
	public ResponseEntity<ApiResponse> saveUser(@RequestBody UserDto user) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_USER_REGISTERED,
				this.service.saveUser(user));
	}

	@PostMapping(ManagementUrlConstants.URL_LOGIN)
	public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDto loginDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_TOKEN_GENERATED,
				new UserTokenDto(service.findByEmailId(loginDto.getEmailId()),
						tokenService.generateTokens(loginDto.getEmailId(), loginDto.getPassword())));
	}

	@PostMapping(ManagementUrlConstants.URL_CHANGE_PASSWORD)
	public ResponseEntity<ApiResponse> updatePassword(@RequestBody ChangePasswordDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_CHANGE_PASSWORD,
				service.updatePassword(dto));
	}

	@PostMapping(ManagementUrlConstants.URL_ADD_USER)
	public ResponseEntity<ApiResponse> addUser(@RequestBody UserDto user) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_USER_REGISTERED,
				this.service.addUser(user));
	}

//	@RolesAllowed({"patient","physician"})
	@GetMapping(ManagementUrlConstants.URL_PATIENT_USERS)
	public ResponseEntity<ApiResponse> getpatients() {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_RECORDS_FETCHED,
				this.service.getPatients());
	}

	@GetMapping(ManagementUrlConstants.URL_HOSPITAL_USERS)
	public ResponseEntity<ApiResponse> getHospitalUsers() {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_RECORDS_FETCHED,
				this.service.getHospitalUsers());
	}

	@PutMapping(ManagementUrlConstants.URL_STATUS)
	public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto user) {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_STATUS_UPDATED,
				this.service.updateStatus(user));
	}

	@PutMapping(ManagementUrlConstants.URL_UPDATE_USER)
	public ResponseEntity<ApiResponse> updateUserDetails(@RequestBody UserDto user) {
		return ResponseUtil.getResponse(HttpStatus.OK, ManagementConstants.PMS_STATUS_UPDATED,
				this.service.updateUserDetails(user));
	}

	@GetMapping(ManagementUrlConstants.URL_USERDATA)
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long userId) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful", this.service.findByUserId(userId));
	}

	@GetMapping(ManagementUrlConstants.URL_MONTHLY_WISE_DATA)
	public ResponseEntity<ApiResponse> getMonthlyRegisteredData() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful", this.service.monthWiseData());
	}
	
	@PostMapping(ManagementUrlConstants.URL_FORGOT_PASSWORD)
	public ResponseEntity<ApiResponse> forgotPassword(@RequestBody EmailIdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful", this.service.forgotPassword(dto.getEmailId()));
	}

}
