package com.pms.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.management.entites.MenuEntity;
import com.pms.management.repository.MenuRepository;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.ResponseUtil;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepo; 
	
	@Override
	public ResponseEntity<ApiResponse> getMenusByRoleId(Integer roleId) {
		Optional<List<MenuEntity>> optional = menuRepo.findByRoleIdOrderByMenuId(roleId);
		List<MenuEntity> menus = null;
		if (optional.isPresent()) {
			menus = optional.get();
			return ResponseUtil.getResponse(HttpStatus.OK,"Menus Fetched Successful",menus);
		
		}
		else {
			return ResponseUtil.getResponse(HttpStatus.BAD_REQUEST, "Failed",null);
		
		}
	}

}
