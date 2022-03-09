package com.pms.management.converter;

import org.springframework.beans.BeanUtils;

import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.utils.BaseConverter;

public class DemographicDetailConverter implements BaseConverter<DemographicDetailEntity,DemographicDetailDto> {
	@Override
	public DemographicDetailEntity toEntity(DemographicDetailDto dto) {
		DemographicDetailEntity entity = new DemographicDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DemographicDetailDto toDto(DemographicDetailEntity entity) {
		DemographicDetailDto dto = new DemographicDetailDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
