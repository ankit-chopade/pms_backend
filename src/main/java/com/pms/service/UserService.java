package com.pms.service;

import com.pms.entity.UserEntity;

public interface UserService {
	
	public UserEntity validateUser(String name,String password);

}
