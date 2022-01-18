package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.entity.MenuEntity;
import com.pms.entity.UserEntity;
import com.pms.service.MenuService;
import com.pms.service.UserService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")

public class LoginController {
	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	MenuService menuService;
//	
//	
//	@PostMapping("login")
//	public ResponseEntity<ApiResponse> Login(@RequestBody UserEntity user){
//		return this.userService.validateUser(user.getFirstName(), user.getPassword());
//	}
//	@PostMapping("menus")
//	public ResponseEntity<ApiResponse> getMenus(@RequestBody MenuEntity menu){
//		return this.menuService.getMenusByRoleId(menu.getRoleId());
//
//	}
	
	

}
