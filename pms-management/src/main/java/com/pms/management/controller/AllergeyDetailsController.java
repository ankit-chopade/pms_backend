package com.pms.management.controller;

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

import com.pms.management.dto.AllergyDto;
import com.pms.management.services.AllergyService;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.ResponseUtil;
import com.pms.management.constants.DemographicDetailUrlConstants;




@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyService allergeyDetailsservice;

	@PostMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyDto  dto){
	
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyDetailsservice.save(dto));
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYID)
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long allergyId){
	
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyDetailsservice.getAllergybyId(allergyId));
	}	
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getAllergyDetails());
	}
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYCODE)
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getbyAllergyCode(allergyCode));
	}
	
	
}
