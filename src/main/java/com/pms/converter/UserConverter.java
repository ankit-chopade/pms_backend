package com.pms.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.dto.UserDto;
import com.pms.entity.UserEntity;

@Component
public class UserConverter implements BaseConverter<UserEntity, UserDto> {

	@Override
	public UserEntity toEntity(UserDto dto) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public UserDto toDto(UserEntity entity) {
		UserDto dto= new UserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
