package com.pms.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.management.dto.UserDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.utils.BaseConverter;

@Component
public class UserConverter implements BaseConverter<UserEntity,UserDto> {

	@Override
	public UserEntity toEntity(UserDto dto) {
		UserEntity medicationEntity = new UserEntity();
		BeanUtils.copyProperties(dto, medicationEntity);
		return medicationEntity;
	}

	@Override
	public UserDto toDto(UserEntity entity) {
		UserDto medicationDto = new UserDto();
		BeanUtils.copyProperties(entity, medicationDto);
		return medicationDto;
	}

}
