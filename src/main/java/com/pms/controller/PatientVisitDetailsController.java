package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.PatientVisitDetails;
import com.pms.service.PatientVisitDetailsServices;

@RestController
public class PatientVisitDetailsController {

	
	@Autowired
	private PatientVisitDetailsServices patientVisitDetailsServices;
	
	@PostMapping("/visitdetails")
	public ResponseEntity<?> savePatientVisitDetails(@RequestBody PatientVisitDetails patientVisitDetails){
		return patientVisitDetailsServices.savePatientVisitDetails(patientVisitDetails);
		
	}
}
