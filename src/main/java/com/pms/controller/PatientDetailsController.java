package com.pms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.pms.common.util.ResponseUtil;
import com.pms.entity.PatientBasicDetail;
import com.pms.entity.UserEntity;
import com.pms.service.AllergyDetailsService;
import com.pms.service.EmergencyContactService;
import com.pms.service.PatientBasicDetailService;
import com.pms.service.UserService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class PatientDetailsController {

	@Autowired
	PatientBasicDetailService patientservice;
	
	@Autowired
	EmergencyContactService emergencyservice;
	
	@Autowired
	AllergyDetailsService allergeyDetailsservice;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/savepatientdetails")
	public ResponseEntity<ApiResponse> savePatient(@RequestBody PatientBasicDetail patientEntity){
			 
	return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful", this.patientservice.save(patientEntity));
	   
	}
	
	@GetMapping("/getPatientbyId")
	public ResponseEntity<ApiResponse> getPatientbyId(@RequestParam Integer id ){
	//	PatientEntity b=this.patientservice.getpatientbyId(userid);
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.patientservice.getpatientbyId(id));
	}
	
	@GetMapping("/getUserData")
	public ResponseEntity<ApiResponse> getUserPatientData(@RequestParam Long id)
	{
		System.out.println("In patient controller");
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.userservice.findByUserId(id));
		
	}
	
	
}
