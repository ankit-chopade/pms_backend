package com.pms.diagnosis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.diagnosis.constants.PmsDiagnosisConstants;
import com.pms.diagnosis.constants.PmsDiagnosisUrlConstants;
import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.service.DiagnosisService;
import com.pms.diagnosis.utils.ApiResponse;
import com.pms.diagnosis.utils.CustomException;
import com.pms.diagnosis.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = PmsDiagnosisConstants.PMS_CROSS_ORIGIN)
@RequestMapping(PmsDiagnosisUrlConstants.URL_DIAGNOSIS)

public class DiagnosisController {

	@Autowired
	private DiagnosisService service;

	@GetMapping()
	public ResponseEntity<ApiResponse> getAllDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}

	@PostMapping()
	public ResponseEntity<ApiResponse> saveDiagnosis(@RequestBody DiagnosisDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED,
				this.service.saveDiagnosis(dto));
	}

	@PutMapping()
	public ResponseEntity<ApiResponse> updateDiagnosis(@RequestBody DiagnosisDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED,
				this.service.updateDiagnosis(dto));
	}

	@DeleteMapping()
	public ResponseEntity<ApiResponse> deleteDiagnosis(@RequestParam Long id) throws CustomException {
		this.service.deleteDiagnosis(id);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED);

	}
	
	@GetMapping("/getNonDepricated")
	public ResponseEntity<ApiResponse> getAllNonDepricatedDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsDiagnosisConstants.PMS_RECORDS_FETCHED,
				this.service.getAllNonDepricatedDetails());
	}

}