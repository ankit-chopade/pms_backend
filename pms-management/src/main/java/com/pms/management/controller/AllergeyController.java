package com.pms.management.controller;

import java.util.List;

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
import com.pms.management.constants.ManagementUrlConstants;




@RestController
@RequestMapping(ManagementUrlConstants.URL_ROOT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AllergeyController {
	@Autowired
	AllergyService allergeyService;

	@PostMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyDto  dto){
	
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyService.save(dto));
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYID)
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long allergyId){
	
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyService.getAllergybyId(allergyId));
	}	
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getAllergyDetails());
	}
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYCODE)
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getbyAllergyCode(allergyCode));
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGY_LIST)
	public ResponseEntity<ApiResponse> getUserPatientAllergyList(@RequestParam List<Long> allergyId) {
	return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getByAllergyIdIn(allergyId));



	}
	
}
