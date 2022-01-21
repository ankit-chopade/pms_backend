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
import com.pms.service.MenuService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/menus")
	public ResponseEntity<ApiResponse> getMenus(@RequestBody MenuEntity menu) {
		return this.menuService.getMenusByRoleId(menu.getRoleId());

	}

}
