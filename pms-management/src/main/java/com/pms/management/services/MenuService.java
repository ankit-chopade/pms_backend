package com.pms.management.services;

import org.springframework.http.ResponseEntity;

public interface MenuService {
	public  ResponseEntity<com.pms.management.utils.ApiResponse>  getMenusByRoleId(Integer roleId);


}
