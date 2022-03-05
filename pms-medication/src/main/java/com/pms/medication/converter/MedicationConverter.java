package com.pms.medication.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.medication.dto.MedicationDto;
import com.pms.medication.entity.MedicationEntity;
import com.pms.medication.utils.BaseConverter;

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
