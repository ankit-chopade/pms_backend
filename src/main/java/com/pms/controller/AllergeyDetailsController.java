package com.pms.controller;

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

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.PmsConstant;
import com.pms.common.util.PmsUrlConstants;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.AllergyDto;
import com.pms.entity.AllergyEntity;
import com.pms.service.AllergyDetailsService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyDetailsService allergeyDetailsservice;

	@PostMapping(PmsUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyDto  dto){
	
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyDetailsservice.save(dto));
	}
	
	@GetMapping("/allergyById")
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Integer allergyId){
	
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyDetailsservice.getAllergybyId(allergyId));
	}
	
	
	@GetMapping(PmsUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getAllergyDetails());
	}
	@GetMapping("/allergy/allergycode")
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getbyAllergyCode(allergyCode));
	}
	
	@DeleteMapping(PmsUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> deleteAllergy(@RequestParam Integer allergyId){
		this.allergeyDetailsservice.deleteallergy(allergyId);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED);
				
	}
}
