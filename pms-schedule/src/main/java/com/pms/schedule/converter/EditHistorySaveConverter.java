package com.pms.schedule.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.schedule.dto.EditHistorySaveDto;
import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.utils.BaseConverter;

@Component
public class EditHistorySaveConverter implements BaseConverter<EditHistoryEntity, EditHistorySaveDto>{

	@Override
	public EditHistoryEntity toEntity(EditHistorySaveDto dto) {
		EditHistoryEntity entity = new EditHistoryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public EditHistorySaveDto toDto(EditHistoryEntity entity) {
		EditHistorySaveDto dto = new EditHistorySaveDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
