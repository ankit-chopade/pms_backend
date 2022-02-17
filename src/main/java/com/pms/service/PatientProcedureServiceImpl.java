package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.PatientProcedureConverter;
import com.pms.dto.PatientProcedureDto;
import com.pms.dto.ProcedureDto;
import com.pms.entity.PatientProcedureEntity;
import com.pms.repository.PatientProcedureRepository;
import com.pms.util.PmsUtil;

@Service
public class PatientProcedureServiceImpl implements PatientProcedureService {

	@Autowired
	private PatientProcedureRepository repository;

	@Autowired
	private PatientProcedureConverter converter;

	@Override
	public List<ProcedureDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		List<ProcedureDto> dto = list.stream().map(obj -> {
			ProcedureDto data = new ProcedureDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoInteger(obj[3]),PmsUtil.convertObjectIntoLong(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]),PmsUtil.convertObjectIntoLong(obj[6]),PmsUtil.convertObjectIntoString(obj[7]));
			return data;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public PatientProcedureDto savePatientProcedure(PatientProcedureDto dto) {
		// Long patientId =
		// appointmentService.getDataByAppointmentId(dto.getAppointmentId());
		Long patientId = 19l;
		PatientProcedureEntity entity = converter.toEntity(dto);
		entity.setPatientId(patientId);
		entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientProcedureEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
	
	@Override
	public void deleteById(Long patientProcedureId) {
		repository.deleteById(patientProcedureId);
	}
	

}
