package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.entity.PatientVisitDetails;
import com.pms.repository.PatientVisitDetailsRepository;

@Service
public class PatientVisitDetailsImpl implements PatientVisitDetailsServices{

	@Autowired
	private PatientVisitDetailsRepository patientVisitDetailsRepository;
	
	
	@Override
	public ResponseEntity<?> savePatientVisitDetails(PatientVisitDetails patientVisitDetails) {
	
		if (patientVisitDetails != null) {
			
			patientVisitDetailsRepository.save(patientVisitDetails);
			return new ResponseEntity<PatientVisitDetails>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<PatientVisitDetails>(HttpStatus.BAD_REQUEST);
		}
		
		
	}

	
	
}
