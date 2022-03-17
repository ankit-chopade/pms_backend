package com.pms.visit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.constants.PmsVisitUrlConstants;
import com.pms.visit.dto.IdAndDateDto;
import com.pms.visit.service.PatientVisitHistoryService;
import com.pms.visit.utils.ApiResponse;
import com.pms.visit.utils.ResponseUtil;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(PmsVisitUrlConstants.URL_VISIT)
public class PatientVisitHistoryController {
	
	@Autowired
	private PatientVisitHistoryService service;

	@PostMapping(PmsVisitUrlConstants.URL_PATIENT_HISTORY)
	public ResponseEntity<ApiResponse> getDetailByAppointmentId(@RequestBody IdAndDateDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getAllVisitByDateAndId(dto));
	}

}
