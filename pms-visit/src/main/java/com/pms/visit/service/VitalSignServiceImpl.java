package com.pms.visit.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.converter.VitalSignConverter;
import com.pms.visit.dto.DashboardVitalDto;
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

	@Override
	public List<String> getBloodPressure(Long patientId) {
		return repository.findBloodPressureByPatientId(patientId);
	}

	@Override
	public List<String> getRespirationRate(Long patientId) {
		return repository.findRespirationRateByPatientId(patientId);
	}
	
	@Override
	public DashboardVitalDto getLatestVitalSigns(Long patientId) {
		 String obj = repository.findLatestVitalSignsByPatientId(patientId);
		 String[] vitalSigns = obj.split(",");
		 return new DashboardVitalDto(
				 Integer.parseInt(vitalSigns[0]),
				 vitalSigns[1],
				 Integer.parseInt(vitalSigns[2]),
				 vitalSigns[3]
				 );
	}

}
