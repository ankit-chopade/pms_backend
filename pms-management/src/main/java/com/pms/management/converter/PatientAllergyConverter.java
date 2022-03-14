package com.pms.management.converter;

import org.springframework.beans.BeanUtils;

import com.pms.management.dto.PatientAllergyDto;
import com.pms.management.entites.PatientAllergyEntity;
import com.pms.management.utils.BaseConverter;

public class PatientAllergyConverter implements BaseConverter<PatientAllergyEntity,PatientAllergyDto>  {
	@Override
	public PatientAllergyEntity toEntity(PatientAllergyDto dto) {
		PatientAllergyEntity entity = new PatientAllergyEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientAllergyDto toDto(PatientAllergyEntity entity) {
		PatientAllergyDto dto = new PatientAllergyDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
