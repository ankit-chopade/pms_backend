package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.PmsConstant;
import com.pms.common.util.PmsUrlConstants;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.PatientMedicationDto;
import com.pms.service.PatientMedicationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientMedicationController {
	@Autowired
	private PatientMedicationService service;

	@GetMapping(PmsUrlConstants.URL_PATIENT_MEDICATION)
	public ResponseEntity<ApiResponse> getDetailByAppointmentId(@RequestParam Long appointmentId) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.getDetailByAppointmentId(appointmentId));
	}

	@PostMapping(PmsUrlConstants.URL_PATIENT_MEDICATION)
	public ResponseEntity<ApiResponse> savePatientDiagnosis(@RequestBody PatientMedicationDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.service.savePatientMedication(dto));
	}

	@DeleteMapping(PmsUrlConstants.URL_PATIENT_MEDICATION)
	public ResponseEntity<ApiResponse> deleteDiagnosisById(@RequestParam Long patientMedicationId) {
		this.service.deleteById(patientMedicationId);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED, null);
	}
}
