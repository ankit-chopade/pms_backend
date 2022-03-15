package com.pms.management.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.utils.BaseConverter;

@Component
public class DemographicDetailConverter implements BaseConverter<DemographicDetailEntity,DemographicDetailDto> {
	@Autowired
	private EmergencyContactConverter emergencyConverter;
	
	@Autowired
	private PatientAllergyConverter patientAllergyConverter;
	
	@Override
	public DemographicDetailEntity toEntity(DemographicDetailDto dto) {
		
		patientAllergyConverter.toEntity(dto.getPatientAllergy());
		DemographicDetailEntity entity = new DemographicDetailEntity();
		entity.setEmergencyContactEntity(emergencyConverter.toEntity(dto.getEmergencyContactEntity()));
		entity.setPatientAllergy(patientAllergyConverter.toEntity(dto.getPatientAllergy()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DemographicDetailDto toDto(DemographicDetailEntity entity) {
		DemographicDetailDto dto = new DemographicDetailDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setEmergencyContactEntity(emergencyConverter.toDto(entity.getEmergencyContactEntity()));
		dto.setPatientAllergy(patientAllergyConverter.toDto(entity.getPatientAllergy()));
		return dto;
	}

}
