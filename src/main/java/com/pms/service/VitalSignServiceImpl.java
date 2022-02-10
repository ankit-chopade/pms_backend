package com.pms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.VitalSignConverter;
import com.pms.dto.VitalSignDto;
import com.pms.entity.VitalSignEntity;
import com.pms.repository.VitalSignRepository;

@Service
public class VitalSignServiceImpl implements VitalSignService {

	@Autowired
	private VitalSignRepository repository;

	@Autowired
	private VitalSignConverter converter;

	@Override
	public VitalSignDto getDetailByAppointmentId(Long appointmentId) {
		VitalSignEntity entity = repository.findByAppointmentId(appointmentId);
		return converter.toDto(entity);
	}

	@Override
	public VitalSignDto saveVitalSigns(VitalSignDto dto) {

		VitalSignEntity entity = converter.toEntity(dto);
		entity.setCreatedDate(new Date());
		entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
		entity = repository.save(entity);
		return converter.toDto(entity);
	}

}
