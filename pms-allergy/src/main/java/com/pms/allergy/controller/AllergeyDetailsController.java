package com.pms.allergy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.allergy.constants.PmsAllergyConstants;
import com.pms.allergy.constants.PmsAllergyUrlConstants;
import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.service.AllergyService;
import com.pms.allergy.utils.ApiResponse;
import com.pms.allergy.utils.CustomException;
import com.pms.allergy.utils.ResponseUtil;


@RestController
@RequestMapping(PmsAllergyUrlConstants.URL_ALLERGY)
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyService service;

//	@GetMapping(PmsAllergyUrlConstants.URL_ALLERGY/{allergyId})
//	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long allergyId){
//		return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.service.getAllergybyId(allergyId));
//	}
	
	@GetMapping()
	public ResponseEntity<ApiResponse> getAllergyDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.service.getAllDetails());
	}
	
	@PostMapping()
	public ResponseEntity<ApiResponse> saveAllergy(@RequestBody AllergyDto  dto) throws CustomException{
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.service.saveAllergy(dto));
	}
	
//	@GetMapping(PmsAllergyUrlConstants.URL_ALLERGYCODE)
//	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
//		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.service.getbyAllergyCode(allergyCode));
//	}
	
	@PutMapping()
	public ResponseEntity<ApiResponse> updateAllergy(@RequestBody AllergyDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, PmsAllergyConstants.PMS_RECORDS_FETCHED,
				this.service.updateAllergy(dto));
	}
	
	@DeleteMapping()
	public ResponseEntity<ApiResponse> deleteAllergy(@RequestParam Long allergyId) throws CustomException{
		this.service.deleteAllergy(allergyId);
		return ResponseUtil.getResponse(HttpStatus.OK, PmsAllergyConstants.PMS_RECORDS_FETCHED);
				
	}
}
