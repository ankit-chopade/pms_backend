package com.pms.allergy.controller;

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

import com.pms.allergy.constants.PmsAllergyConstants;
import com.pms.allergy.constants.PmsAllergyUrlConstants;
import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.service.AllergyService;
import com.pms.allergy.utils.ApiResponse;
import com.pms.allergy.utils.ResponseUtil;



@RestController

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyService allergeyDetailsservice;

	@PostMapping(PmsAllergyUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyDto  dto){
	
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyDetailsservice.save(dto));
	}
	
	@GetMapping(PmsAllergyUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long allergyId){
	
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyDetailsservice.getAllergybyId(allergyId));
	}
	
	
	@GetMapping(PmsAllergyUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getAllergyDetails());
	}
	@GetMapping(PmsAllergyUrlConstants.URL_ALLERGYCODE)
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getbyAllergyCode(allergyCode));
	}
	
	@DeleteMapping(PmsAllergyUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> deleteAllergy(@RequestParam Long allergyId){
		this.allergeyDetailsservice.deleteAllergy(allergyId);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsAllergyConstants.PMS_RECORDS_FETCHED);
				
	}
}
