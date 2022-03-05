package com.pms.procedure.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.entity.ProcedureEntity;
import com.pms.procedure.utils.BaseConverter;

@Component
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
