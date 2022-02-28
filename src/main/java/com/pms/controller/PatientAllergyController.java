package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.ResponseUtil;
import com.pms.service.AllergyMapService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class PatientAllergyController {
	
	@Autowired
	AllergyMapService service;
	
	

}
