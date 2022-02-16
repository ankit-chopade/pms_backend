package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.AllergyEntity;
import com.pms.service.EmergencyContactService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class emergencyDeatilsController {
	@Autowired
	EmergencyContactService emergencyservice;
	private Object allergeyDetailsservice;
	
//	@PostMapping("allergy")
//	public AllergyDetailsEntity saveallergey(@RequestBody AllergyDetailsEntity allergyDetailsEntity){
//		return this.allergeyDetailsservice.save(allergyDetailsEntity);
//	}
//	
//	@GetMapping("getallergy")
//	public AllergyDetailsEntity getAllergybyId(int allergyId){
//		return this.allergeyDetailsservice.getAllergybyId(allergyId);
//	}
	
}
