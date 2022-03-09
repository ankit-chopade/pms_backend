package com.pms.management.controller;

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

import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.services.DemographicDetailService;
import com.pms.management.services.ManagementService;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.ResponseUtil;


@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DemographicDetailController {

	@Autowired
	DemographicDetailService patientservice;

	

	@Autowired
	ManagementService managementservice;

	@PostMapping("/patientBasicDetail")
	public ResponseEntity<ApiResponse> savePatient(@RequestBody DemographicDetailDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful", this.patientservice.save(dto));

	}

	@GetMapping("/getPatientbyId")
	public ResponseEntity<ApiResponse> getPatientbyId(@RequestParam Long id) {
		// PatientEntity b=this.patientservice.getpatientbyId(userid);
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.patientservice.getpatientbyId(id));
	}

	@GetMapping("/user")
	public ResponseEntity<ApiResponse> getUserPatientData(@RequestParam Long id) throws CustomException {
		System.out.println("In patient controller");
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.managementservice.findByUserId(id));

	}

}
