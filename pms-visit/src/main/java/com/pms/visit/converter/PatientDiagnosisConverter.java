package com.pms.visit.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.visit.dto.PatientDiagnosisDto;
import com.pms.visit.entity.PatientDiagnosisEntity;
import com.pms.visit.utils.BaseConverter;

@Component
public class PatientDiagnosisConverter implements BaseConverter<PatientDiagnosisEntity, PatientDiagnosisDto> {

	@Override
	public PatientDiagnosisEntity toEntity(PatientDiagnosisDto dto) {
		PatientDiagnosisEntity entity = new PatientDiagnosisEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientDiagnosisDto toDto(PatientDiagnosisEntity entity) {
		PatientDiagnosisDto dto = new PatientDiagnosisDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
