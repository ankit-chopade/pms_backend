package com.pms.converter;

import org.springframework.beans.BeanUtils;

import com.pms.dto.ProcedureDto;
import com.pms.entity.ProcedureEntity;

public class ProcedureConverter implements BaseConverter<ProcedureEntity, ProcedureDto> {

	@Override
	public ProcedureEntity toEntity(ProcedureDto dto) {
		ProcedureEntity entity = new ProcedureEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public ProcedureDto toDto(ProcedureEntity entity) {
		ProcedureDto dto = new ProcedureDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
