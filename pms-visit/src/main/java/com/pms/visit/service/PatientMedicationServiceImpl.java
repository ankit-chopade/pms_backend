package com.pms.visit.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.converter.PatientMedicationConverter;
import com.pms.visit.dto.PatientMedicationDto;
import com.pms.visit.dto.PatientMedicationViewDto;
import com.pms.visit.entity.PatientMedicationEntity;
import com.pms.visit.repository.PatientMedicationRepository;
import com.pms.visit.utils.PmsVisitUtil;

@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

	@Autowired
	private PatientMedicationRepository repository;

	@Autowired
	private PatientMedicationConverter converter;

	@Override
	public List<PatientMedicationViewDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		
		return list.stream().map(obj -> 
			 new PatientMedicationViewDto(PmsVisitUtil.convertObjectIntoLong(obj[0]),
					PmsVisitUtil.convertObjectIntoString(obj[1]), PmsVisitUtil.convertObjectIntoString(obj[2]),
					PmsVisitUtil.convertObjectIntoString(obj[3]), PmsVisitUtil.convertObjectIntoString(obj[4]),
					PmsVisitUtil.convertObjectIntoString(obj[5]), PmsVisitUtil.convertObjectIntoString(obj[6]),
					PmsVisitUtil.convertObjectIntoLong(obj[7]), PmsVisitUtil.convertObjectIntoString(obj[8]),
					PmsVisitUtil.convertObjectIntoLong(obj[9]), PmsVisitUtil.convertObjectIntoString(obj[10]))
		).collect(Collectors.toList());
	}

	@Override
	public PatientMedicationDto savePatientMedication(PatientMedicationDto dto) {

	
		PatientMedicationEntity entity = converter.toEntity(dto);
		entity.setActiveStatus(PmsVisitConstants.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientMedicationEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
	
	@Override
	public void deleteById(Long patientMedicationId) {
		repository.deleteById(patientMedicationId);
	}

}
