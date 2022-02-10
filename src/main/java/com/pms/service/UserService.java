package com.pms.service;

import java.util.Optional;

import com.pms.common.exception.CustomException;
import com.pms.entity.UserEntity;

public interface UserService {

	public UserEntity saveUser(UserEntity user) throws CustomException;

	public UserEntity findByEmailId(String emailId);
	public Optional<UserEntity> findByUserId(Long userId);

}
