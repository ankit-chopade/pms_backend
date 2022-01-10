package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.UserEntity;
import com.pms.service.UserService;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	UserService service;
	
	@GetMapping("check")
	public String check() {
		return "Checked";
	}
	
	@GetMapping("login")
	public UserEntity Login(@RequestParam String name ,@RequestParam String password){
		return service.validateUser(name, password);
	}
	
	

}
