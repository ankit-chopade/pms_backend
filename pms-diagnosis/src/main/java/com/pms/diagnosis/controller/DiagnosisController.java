package com.pms.diagnosis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.diagnosis.constants.PmsDiagnosisConstants;
import com.pms.diagnosis.constants.PmsDiagnosisUrlConstants;
import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.service.DiagnosisService;
import com.pms.diagnosis.utils.ApiResponse;
import com.pms.diagnosis.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = PmsDiagnosisConstants.PMS_CROSS_ORIGIN)
public class DiagnosisController {

	@Autowired
	private DiagnosisService service;

	@PostMapping(PmsDiagnosisUrlConstants.URL_DIAGNOSIS)
	public ResponseEntity<ApiResponse> saveDiagnosis(@RequestBody DiagnosisDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED,
				this.service.saveDiagnosis(dto));
	}

}