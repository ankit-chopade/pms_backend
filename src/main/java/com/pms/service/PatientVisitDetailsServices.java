package com.pms.service;

import org.springframework.http.ResponseEntity;

import com.pms.entity.PatientVisitDetails;

public interface PatientVisitDetailsServices {

	
	public ResponseEntity<?> savePatientVisitDetails(PatientVisitDetails patientVisitDetails);
}
