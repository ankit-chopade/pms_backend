package com.pms.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.dto.MedicationDto;
import com.pms.entity.MedicationEntity;

@Component
public class MedicationConverter implements BaseConverter<MedicationEntity, MedicationDto> {

	@Override
	public MedicationEntity toEntity(MedicationDto dto) {
		MedicationEntity medicationEntity = new MedicationEntity();
		BeanUtils.copyProperties(dto, medicationEntity);
		return medicationEntity;
	}

	@Override
	public MedicationDto toDto(MedicationEntity entity) {
		MedicationDto medicationDto = new MedicationDto();
		BeanUtils.copyProperties(entity, medicationDto);
		return medicationDto;
	}

}
