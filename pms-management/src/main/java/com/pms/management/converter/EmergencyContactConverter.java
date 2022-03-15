package com.pms.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.management.dto.EmergencyContactDto;
import com.pms.management.entites.EmergencyContactEntity;
import com.pms.management.utils.BaseConverter;

@Component
public class EmergencyContactConverter implements BaseConverter<EmergencyContactEntity,EmergencyContactDto> {

	@Override
	public EmergencyContactEntity toEntity(EmergencyContactDto dto) {
		EmergencyContactEntity entity = new EmergencyContactEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public EmergencyContactDto toDto(EmergencyContactEntity entity) {
		EmergencyContactDto dto = new EmergencyContactDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
