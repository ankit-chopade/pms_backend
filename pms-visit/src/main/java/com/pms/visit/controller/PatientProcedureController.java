package com.pms.visit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.constants.PmsVisitUrlConstants;
import com.pms.visit.dto.PatientProcedureDto;
import com.pms.visit.service.PatientProcedureService;
import com.pms.visit.utils.ApiResponse;
import com.pms.visit.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(PmsVisitUrlConstants.URL_VISIT)
public class PatientProcedureController {
	
	@Autowired
	private PatientProcedureService service;

	@GetMapping(PmsVisitUrlConstants.URL_PATIENT_PROCEDURE)
	public ResponseEntity<ApiResponse> getDetailByAppointmentId(@RequestParam Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getDetailByAppointmentId(id));
	}

	@PostMapping(PmsVisitUrlConstants.URL_PATIENT_PROCEDURE)
	public ResponseEntity<ApiResponse> savePatientDiagnosis(@RequestBody PatientProcedureDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.savePatientProcedure(dto));
	}
	

	@DeleteMapping(PmsVisitUrlConstants.URL_PATIENT_PROCEDURE)
	public ResponseEntity<ApiResponse> deleteProcedureById(@RequestParam Long patientProcedureId) {
		this.service.deleteById(patientProcedureId);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED, null);
	}

}
