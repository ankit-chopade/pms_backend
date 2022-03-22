package com.pms.management.services;

import java.util.List;

import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.IdAndNameDto;
import com.pms.management.dto.UserDetailsViewDto;
import com.pms.management.dto.UserDto;
import com.pms.management.dto.UserViewDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.utils.CustomException;

public interface ManagementService {

	public UserDto saveUser(UserDto user) throws CustomException;

	public UserDto addUser(UserDto user) throws CustomException;

	public UserDetailsViewDto findByEmailId(String emailId) throws CustomException;

	public UserDetailsViewDto updatePassword(ChangePasswordDto dto) throws CustomException;

	public UserEntity findByUserId(Long userId) throws CustomException;

	public List<UserViewDto> getPatients();

	public UserDto updateStatus(UserDto user);
	
	public UserDto updateUserDetails(UserDto user);

	public List<UserViewDto> getHospitalUsers();
	
	public List<IdAndNameDto> monthWiseData();
	
	public UserDto forgotPassword(String emailId) throws CustomException;

}
