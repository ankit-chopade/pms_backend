package com.pms.visit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.converter.VitalSignConverter;
import com.pms.visit.dto.VitalSignDto;
import com.pms.visit.entity.VitalSignEntity;
import com.pms.visit.repository.VitalSignRepository;

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
		entity.setActiveStatus(PmsVisitConstants.ACTIVE_STATUS);
		entity = repository.save(entity);
		return converter.toDto(entity);
	}

}
