package com.pms.visit.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.visit.dto.VitalSignDto;
import com.pms.visit.entity.VitalSignEntity;
import com.pms.visit.utils.BaseConverter;

@Component
public class VitalSignConverter implements BaseConverter<VitalSignEntity, VitalSignDto>{

	@Override
	public VitalSignEntity toEntity(VitalSignDto dto) {
		VitalSignEntity entity = new VitalSignEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public VitalSignDto toDto(VitalSignEntity entity) {
		
		VitalSignDto dto = new VitalSignDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	

}
