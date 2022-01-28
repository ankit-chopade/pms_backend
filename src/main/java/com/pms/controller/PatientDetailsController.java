package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.entity.PatientEntity;
import com.pms.entity.UserEntity;
import com.pms.service.AllergyDetailsService;
import com.pms.service.EmergencyContactService;
import com.pms.service.PatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class PatientDetailsController {

	@Autowired
	PatientService patientservice;
	
	@Autowired
	EmergencyContactService emergencyservice;
	
	@Autowired
	AllergyDetailsService allergeyDetailsservice;
	
	@PostMapping("/savepatientdetails")
	public void savePatient(@RequestBody PatientEntity patientEntity){
		System.out.println(patientEntity);
	   this.patientservice.save(patientEntity);
	   
	}
	
	@PostMapping("/getPatientbyId")
	public PatientEntity getPatientbyId(@RequestBody PatientEntity patientEntity ){
		
		return this.patientservice.getpatientbyId(patientEntity.getPatientId());
	}
	
	@PostMapping("check")
	public String check()
	{
		return "Hello";
	}
}
