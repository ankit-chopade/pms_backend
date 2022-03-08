package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.exception.CustomException;
import com.pms.common.util.ResponseUtil;
import com.pms.entity.DemographicDetail;
import com.pms.service.AllergyService;
import com.pms.service.EmergencyContactService;
import com.pms.service.DemographicDetailService;
import com.pms.service.UserService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DemographicDetailController {

	@Autowired
	DemographicDetailService patientservice;

	@Autowired
	EmergencyContactService emergencyservice;

	@Autowired
	AllergyService allergeyDetailsservice;

	@Autowired
	UserService userservice;

	@PostMapping("/patientBasicDetail")
	public ResponseEntity<ApiResponse> savePatient(@RequestBody DemographicDetail patientEntity) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful", this.patientservice.save(patientEntity));

	}

	@GetMapping("/getPatientbyId")
	public ResponseEntity<ApiResponse> getPatientbyId(@RequestParam Integer id) {
		// PatientEntity b=this.patientservice.getpatientbyId(userid);
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.patientservice.getpatientbyId(id));
	}

	@GetMapping("/user")
	public ResponseEntity<ApiResponse> getUserPatientData(@RequestParam Long id) throws CustomException {
		System.out.println("In patient controller");
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.userservice.findByUserId(id));

	}

}
