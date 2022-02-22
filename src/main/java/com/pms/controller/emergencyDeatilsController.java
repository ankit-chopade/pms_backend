package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.service.EmergencyContactService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class emergencyDeatilsController {
	@Autowired
	EmergencyContactService emergencyservice;
	
	

	
}
