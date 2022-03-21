package com.pms.schedule.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.utils.BaseConverter;

@Component
public class PatientAppointmentConverter implements BaseConverter<PatientAppointmentEntity, PatientAppointmentDto> {

	@Override
	public PatientAppointmentEntity toEntity(PatientAppointmentDto dto) {
		PatientAppointmentEntity entity = new PatientAppointmentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientAppointmentDto toDto(PatientAppointmentEntity entity) {
		PatientAppointmentDto dto = new PatientAppointmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
