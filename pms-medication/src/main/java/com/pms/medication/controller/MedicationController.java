package com.pms.medication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.medication.constants.PmsMedicationConstants;
import com.pms.medication.constants.PmsMedicationUrlConstants;
import com.pms.medication.service.MedicationService;
import com.pms.medication.utils.ApiResponse;
import com.pms.medication.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = PmsMedicationConstants.PMS_CROSS_ORIGIN)
public class MedicationController {

	@Autowired
	private MedicationService service;

	@GetMapping(PmsMedicationUrlConstants.URL_MEDICATION)
	public ResponseEntity<ApiResponse> getAllDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsMedicationConstants.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}

}
