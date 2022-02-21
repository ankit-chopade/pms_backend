package com.pms.controller;

import java.util.List;
import java.util.Set;

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
import com.pms.common.util.ResponseUtil;
import com.pms.entity.AllergyEntity;
import com.pms.entity.PatientBasicDetail;
import com.pms.service.AllergyDetailsService;
import com.pms.service.PatientBasicDetailService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyDetailsService allergeyDetailsservice;

	@PostMapping("allergy")
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyEntity  allergyDetailsEntity){
	//	this.allergeyDetailsservice.save(allergyDetailsEntity);
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyDetailsservice.save(allergyDetailsEntity));
	}
	
	@GetMapping("allergyById")
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Integer allergyId){
	
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyDetailsservice.getAllergybyId(allergyId));
	}
	
	/*
	 * @PostMapping("getallergyType") public AllergyDetailsEntity
	 * getAllergytype(@RequestBody AllergyDetailsEntity allergy){ return
	 * this.allergeyDetailsservice.getAllergyType(allergy.getAllergyType()); }
	 * 
	 * @PostMapping("getallergyName") public AllergyDetailsEntity
	 * getAllergyName(@RequestBody AllergyDetailsEntity allergy){ return
	 * this.allergeyDetailsservice.getAllergyName(allergy.getAllergyName()); }
	 */
	
	@GetMapping("/allergy")
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getAllergyDetails());
	}
	@GetMapping("/allergy/allergycode")
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyDetailsservice.getbyAllergyCode(allergyCode));
	}
}
