package com.pms.visit.service;

import java.util.Date;
import java.util.Optional;

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
	public VitalSignDto getDetailByAppointmentId(Long id) {
		Optional<VitalSignEntity> optional = repository.findByAppointmentId(id);
		if(optional.isPresent()) {
			return converter.toDto(optional.get());
		}
		return null;
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
