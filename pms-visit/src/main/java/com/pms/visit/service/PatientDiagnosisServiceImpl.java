package com.pms.visit.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.converter.PatientDiagnosisConverter;
import com.pms.visit.dto.PatientDiagnosisDto;
import com.pms.visit.dto.PatientDiagnosisViewDto;
import com.pms.visit.entity.PatientDiagnosisEntity;
import com.pms.visit.repository.PatientDiagnosisRepository;
import com.pms.visit.utils.PmsVisitUtil;

@Service
public class PatientDiagnosisServiceImpl implements PatientDiagnosisService {
	
	@Autowired
	private PatientDiagnosisRepository repository;

	@Autowired
	private PatientDiagnosisConverter converter;

	@Override
	public List<PatientDiagnosisViewDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		return list.stream().map(obj -> 
			 new PatientDiagnosisViewDto(PmsVisitUtil.convertObjectIntoLong(obj[0]),
					PmsVisitUtil.convertObjectIntoString(obj[1]), PmsVisitUtil.convertObjectIntoString(obj[2]),
					PmsVisitUtil.convertObjectIntoInteger(obj[3]),PmsVisitUtil.convertObjectIntoLong(obj[4]),
					PmsVisitUtil.convertObjectIntoString(obj[5]),PmsVisitUtil.convertObjectIntoLong(obj[6]),PmsVisitUtil.convertObjectIntoString(obj[7]))
		).collect(Collectors.toList());
	}

	@Override
	public PatientDiagnosisDto savePatientDiagnosis(PatientDiagnosisDto dto) {
		PatientDiagnosisEntity entity = converter.toEntity(dto);
		entity.setActiveStatus(PmsVisitConstants.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientDiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
	
	@Override
	public void deleteById(Long patientDiagnosisId) {
		repository.deleteById(patientDiagnosisId);
	}
	

}
