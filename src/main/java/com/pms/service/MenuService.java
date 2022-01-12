package com.pms.service;

import org.springframework.http.ResponseEntity;

import com.pms.common.entity.ApiResponse;

public interface MenuService {
	public  ResponseEntity<ApiResponse>  getMenusByRoleId(Integer roleId);


}
