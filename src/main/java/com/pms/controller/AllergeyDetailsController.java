package com.pms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.PatientEntity;
import com.pms.service.AllergyDetailsService;
import com.pms.service.PatientService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class AllergeyDetailsController {
	@Autowired
	AllergyDetailsService allergeyDetailsservice;
	
	
	
	@PostMapping("saveallergy")
	public void saveallergey(@RequestBody AllergyDetailsEntity  allergyDetailsEntity){
	 this.allergeyDetailsservice.save(allergyDetailsEntity);
	}
	
	@PostMapping("getallergyid")
	public List<AllergyDetailsEntity> getAllergybyId(@RequestBody AllergyDetailsEntity allergy){
		return this.allergeyDetailsservice.getAllergybyId(allergy);
	}
	
	@PostMapping("getallergyType")
	public AllergyDetailsEntity getAllergytype(@RequestBody AllergyDetailsEntity allergy){
		return this.allergeyDetailsservice.getAllergyType(allergy.getAllergyType());
	}
	
	@PostMapping("getallergyName")
	public AllergyDetailsEntity getAllergyName(@RequestBody AllergyDetailsEntity allergy){
		return this.allergeyDetailsservice.getAllergyName(allergy.getAllergyName());
	}
}
