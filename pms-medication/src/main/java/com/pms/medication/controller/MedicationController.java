package com.pms.medication.controller;

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

import com.pms.medication.constants.PmsMedicationConstants;
import com.pms.medication.constants.PmsMedicationUrlConstants;
import com.pms.medication.dto.MedicationDto;
import com.pms.medication.service.MedicationService;
import com.pms.medication.utils.ApiResponse;
import com.pms.medication.utils.CustomException;
import com.pms.medication.utils.ResponseUtil;

@RestController
@RequestMapping(PmsMedicationUrlConstants.URL_MEDICATION)
@CrossOrigin(origins = PmsMedicationConstants.PMS_CROSS_ORIGIN)
public class MedicationController {

	@Autowired
	private MedicationService service;

	@GetMapping()
	public ResponseEntity<ApiResponse> getAllDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsMedicationConstants.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}

	@PostMapping()
	public ResponseEntity<ApiResponse> saveDiagnosis(@RequestBody MedicationDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsMedicationConstants.PMS_RECORDS_FETCHED,
				this.service.saveDiagnosis(dto));
	}

	@PutMapping()
	public ResponseEntity<ApiResponse> updateDiagnosis(@RequestBody MedicationDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsMedicationConstants.PMS_RECORDS_FETCHED,
				this.service.updateDiagnosis(dto));
	}

	@DeleteMapping()
	public ResponseEntity<ApiResponse> deleteDiagnosis(@RequestParam Long id) throws CustomException {
		this.service.deleteDiagnosis(id);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsMedicationConstants.PMS_RECORDS_FETCHED);

	}

}
