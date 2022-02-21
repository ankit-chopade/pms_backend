package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.PatientMedicationConverter;
import com.pms.dto.MedicationDto;
import com.pms.dto.PatientMedicationDto;
import com.pms.entity.PatientMedicationEntity;
import com.pms.repository.PatientMedicationRepository;
import com.pms.util.PmsUtil;

@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

	@Autowired
	private PatientMedicationRepository repository;

	@Autowired
	private PatientMedicationConverter converter;

	@Override
	public List<MedicationDto> getDetailByAppointmentId(Long appointmentId) {
		List<Object[]> list = repository.findByAppointmentId(appointmentId);
		List<MedicationDto> dto = list.stream().map(obj -> {
			MedicationDto data = new MedicationDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoString(obj[3]), PmsUtil.convertObjectIntoString(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]), PmsUtil.convertObjectIntoString(obj[6]),
					PmsUtil.convertObjectIntoLong(obj[7]), PmsUtil.convertObjectIntoString(obj[8]),
					PmsUtil.convertObjectIntoLong(obj[9]), PmsUtil.convertObjectIntoString(obj[10]));
			return data;
		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public PatientMedicationDto savePatientMedication(PatientMedicationDto dto) {

		// Long patientId =
		// appointmentService.getDataByAppointmentId(dto.getAppointmentId());
		Long patientId = 19l;
		PatientMedicationEntity entity = converter.toEntity(dto);
		entity.setPatientId(patientId);
		entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		PatientMedicationEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
	
	@Override
	public void deleteById(Long patientMedicationId) {
		repository.deleteById(patientMedicationId);
	}

}
