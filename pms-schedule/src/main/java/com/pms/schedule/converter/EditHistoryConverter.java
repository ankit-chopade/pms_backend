package com.pms.schedule.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.schedule.dto.EditHistoryDto;
import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.utils.BaseConverter;

@Component
public class EditHistoryConverter implements BaseConverter<EditHistoryEntity, EditHistoryDto> {

	@Override
	public EditHistoryEntity toEntity(EditHistoryDto dto) {
		EditHistoryEntity entity = new EditHistoryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public EditHistoryDto toDto(EditHistoryEntity entity) {
		EditHistoryDto dto = new EditHistoryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
