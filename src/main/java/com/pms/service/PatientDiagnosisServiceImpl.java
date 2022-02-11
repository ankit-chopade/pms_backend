package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.PatientDiagnosisConverter;
import com.pms.dto.DiagnosisDto;
import com.pms.dto.PatientDiagnosisDto;
import com.pms.entity.PatientDiagnosisEntity;
import com.pms.repository.PatientDiagnosisRepository;
import com.pms.util.PmsUtil;

@Service
public class PatientDiagnosisServiceImpl implements PatientDiagnosisService {
	
	@Autowired
	private PatientDiagnosisRepository repository;

	@Autowired
	private PatientDiagnosisConverter converter;

	@Override
	public List<DiagnosisDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		List<DiagnosisDto> dto = list.stream().map(obj -> {
			DiagnosisDto data = new DiagnosisDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoInteger(obj[3]));
			return data;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public PatientDiagnosisDto savePatientDiagnosis(PatientDiagnosisDto dto) {
		
		//Long patientId = appointmentService.getDataByAppointmentId(dto.getAppointmentId());
		Long patientId=19l;
		
		PatientDiagnosisEntity entity = converter.toEntity(dto);
		entity.setPatientId(patientId);
		entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientDiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

}
