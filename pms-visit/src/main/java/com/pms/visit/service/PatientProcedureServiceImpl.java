package com.pms.visit.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.converter.PatientProcedureConverter;
import com.pms.visit.dto.PatientProcedureDto;
import com.pms.visit.dto.PatientProcedureViewDto;
import com.pms.visit.entity.PatientProcedureEntity;
import com.pms.visit.repository.PatientProcedureRepository;
import com.pms.visit.utils.PmsVisitUtil;

@Service
public class PatientProcedureServiceImpl implements PatientProcedureService {

	@Autowired
	private PatientProcedureRepository repository;

	@Autowired
	private PatientProcedureConverter converter;

	@Override
	public List<PatientProcedureViewDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		return list.stream().map(obj -> 
			 new PatientProcedureViewDto(PmsVisitUtil.convertObjectIntoLong(obj[0]),
					PmsVisitUtil.convertObjectIntoString(obj[1]), PmsVisitUtil.convertObjectIntoString(obj[2]),
					PmsVisitUtil.convertObjectIntoInteger(obj[3]), PmsVisitUtil.convertObjectIntoLong(obj[4]),
					PmsVisitUtil.convertObjectIntoString(obj[5]), PmsVisitUtil.convertObjectIntoLong(obj[6]),
					PmsVisitUtil.convertObjectIntoString(obj[7]))
		).collect(Collectors.toList());
	}

	@Override
	public PatientProcedureDto savePatientProcedure(PatientProcedureDto dto) {
		PatientProcedureEntity entity = converter.toEntity(dto);
		entity.setActiveStatus(PmsVisitConstants.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientProcedureEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	@Override
	public void deleteById(Long patientProcedureId) {
		repository.deleteById(patientProcedureId);
	}

}
