package com.pms.schedule.converter;

import org.springframework.beans.BeanUtils;

import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.utils.BaseConverter;

public class PatientAppointmentConverter implements BaseConverter<PatientAppointmentEntity, PatientAppointmentDto> {

	@Override
	public PatientAppointmentEntity toEntity(PatientAppointmentDto dto) {
		PatientAppointmentEntity entity = new PatientAppointmentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PatientAppointmentDto toDto(PatientAppointmentEntity entity) {
		// TODO Auto-generated method stub
		PatientAppointmentDto dto = new PatientAppointmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
