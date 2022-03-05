package com.pms.visit.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.visit.dto.PatientProcedureDto;
import com.pms.visit.entity.PatientProcedureEntity;
import com.pms.visit.utils.BaseConverter;

@Component
public class PatientProcedureConverter implements BaseConverter<PatientProcedureEntity, PatientProcedureDto> {

	@Override
	public PatientProcedureEntity toEntity(PatientProcedureDto dto) {
		PatientProcedureEntity entity = new PatientProcedureEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientProcedureDto toDto(PatientProcedureEntity entity) {
		PatientProcedureDto dto = new PatientProcedureDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
