package com.pms.management.controller;

import java.util.List;

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

import com.pms.management.constants.DemographicDetailUrlConstants;
import com.pms.management.constants.ManagementUrlConstants;
import com.pms.management.dto.AllergyDto;
import com.pms.management.services.AllergyService;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.ResponseUtil;




@RestController
@RequestMapping(ManagementUrlConstants.URL_ROOT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AllergeyController {
	@Autowired
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
	private AllergyService allergyService;
=======
	AllergyService allergeyService;
>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java

	@PostMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> saveallergey(@RequestBody AllergyDto  dto){
	
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergyService.save(dto));
=======
	 return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful" ,this.allergeyService.save(dto));
>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYID)
	public ResponseEntity<ApiResponse> getAllergybyId(@RequestParam Long allergyId){
	
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergyService.getAllergybyId(allergyId));
=======
		 return ResponseUtil.getResponse(HttpStatus.OK, "Data fetch Successful",this.allergeyService.getAllergybyId(allergyId));
>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java
	}	
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGY)
	public ResponseEntity<ApiResponse> getAllergyDetails(){
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergyService.getAllergyDetails());
=======
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getAllergyDetails());
>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGYCODE)
	public ResponseEntity<ApiResponse> getAllergyCode(@RequestParam String allergyCode){
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergyService.getbyAllergyCode(allergyCode));
=======
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getbyAllergyCode(allergyCode));
>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java
	}
	
	@GetMapping(DemographicDetailUrlConstants.URL_ALLERGY_LIST)
	public ResponseEntity<ApiResponse> getUserPatientAllergyList(@RequestParam List<Long> allergyId) {
<<<<<<< HEAD:pms-management/src/main/java/com/pms/management/controller/AllergeyDetailsController.java
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergyService.getAllergyByListId(allergyId));
=======
	return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful", this.allergeyService.getByAllergyIdIn(allergyId));


>>>>>>> origin/jayshree-microservice-testCase:pms-management/src/main/java/com/pms/management/controller/AllergeyController.java

	}
	
}
