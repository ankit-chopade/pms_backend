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
import com.pms.common.util.PmsConstant;
import com.pms.common.util.PmsUrlConstants;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.DiagnosisDto;
import com.pms.service.DiagnosisService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DiagnosisController {

	@Autowired
	private DiagnosisService service;

	@GetMapping(PmsUrlConstants.URL_DIAGNOSIS)
	public ResponseEntity<ApiResponse> getAllDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}
	
	@PostMapping(PmsUrlConstants.URL_DIAGNOSIS)
	public ResponseEntity<ApiResponse> saveDiagnosis(@RequestBody DiagnosisDto dto){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.saveDiagnosis(dto));
	}
	
	
}