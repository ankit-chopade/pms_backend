package com.pms.service;

import com.pms.common.exception.CustomException;
import com.pms.entity.UserEntity;

public interface UserService {

	public UserEntity saveUser(UserEntity user) throws CustomException;

	public UserEntity findByEmailId(String emailId);
	public UserEntity findByUserId(Long userId) throws CustomException;

}
