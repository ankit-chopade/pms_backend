package com.pms.visit.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.visit.dto.PatientMedicationDto;
import com.pms.visit.entity.PatientMedicationEntity;
import com.pms.visit.utils.BaseConverter;

@Component
public class PatientMedicationConverter implements BaseConverter<PatientMedicationEntity, PatientMedicationDto> {

	@Override
	public PatientMedicationEntity toEntity(PatientMedicationDto dto) {
		PatientMedicationEntity entity = new PatientMedicationEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientMedicationDto toDto(PatientMedicationEntity entity) {
		PatientMedicationDto dto = new PatientMedicationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
