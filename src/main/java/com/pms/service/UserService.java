package com.pms.service;

import com.pms.common.exception.CustomException;
import com.pms.dto.ChangePasswordDto;
import com.pms.dto.UserDetailsViewDto;
import com.pms.dto.UserDto;
import com.pms.entity.UserEntity;

public interface UserService {

	public UserDto saveUser(UserDto user) throws CustomException;

	public UserDetailsViewDto findByEmailId(String emailId) throws CustomException;

	public UserDetailsViewDto updatePassword(ChangePasswordDto dto) throws CustomException;

	public UserEntity findByUserId(Long userId) throws CustomException;


}
