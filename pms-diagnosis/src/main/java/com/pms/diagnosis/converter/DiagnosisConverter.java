package com.pms.diagnosis.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.entity.DiagnosisEntity;
import com.pms.diagnosis.utils.BaseConverter;

@Component
public class DiagnosisConverter implements BaseConverter<DiagnosisEntity, DiagnosisDto> {

	@Override
	public DiagnosisEntity toEntity(DiagnosisDto dto) {
		DiagnosisEntity entity = new DiagnosisEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DiagnosisDto toDto(DiagnosisEntity entity) {
		DiagnosisDto dto = new DiagnosisDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
