package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.PmsConstant;
import com.pms.common.util.PmsUrlConstants;
import com.pms.common.util.ResponseUtil;
import com.pms.service.DiagnosisService;

@RestController
@RequestMapping(PmsUrlConstants.URL_DIAGNOSIS)
public class DiagnosisController {

	@Autowired
	private DiagnosisService service;

	@GetMapping(PmsUrlConstants.URL_GET_DETAIL_BY_CODE)
	public ResponseEntity<ApiResponse> getDetailByCode(@RequestParam String code) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.getDetailsByCode(code));
	}

	@GetMapping(PmsUrlConstants.URL_GET_DETAIL_BY_DESCRIPTION)
	public ResponseEntity<ApiResponse> getDetailByDescription(@RequestParam String description) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.getDetailsByDescription(description));
	}
	
	
}