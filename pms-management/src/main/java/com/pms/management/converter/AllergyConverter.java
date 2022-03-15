package com.pms.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.management.dto.AllergyDto;
import com.pms.management.entites.AllergyEntity;
import com.pms.management.utils.BaseConverter;




@Component
public class AllergyConverter implements BaseConverter<AllergyEntity, AllergyDto> {

	@Override
	public AllergyEntity toEntity(AllergyDto dto) {
		AllergyEntity entity = new AllergyEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public AllergyDto toDto(AllergyEntity entity) {
		AllergyDto dto = new AllergyDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
