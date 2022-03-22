package com.pms.management.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.management.constant.JunitConstants;
import com.pms.management.constants.DemographicDetailsConstant;
import com.pms.management.converter.DemographicDetailConverter;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.entites.EmergencyContactEntity;
import com.pms.management.entites.PatientAllergyEntity;
import com.pms.management.repository.DemographicDetailRepository;
import com.pms.management.utils.CustomException;

@ExtendWith(MockitoExtension.class)
class DemographicDetailServiceImplTest {
	@InjectMocks
	DemographicDetailServiceImpl service;

	@Mock
	DemographicDetailRepository patientRepo;

	@Mock
	DemographicDetailConverter converter;

	@Mock
	DemographicDetailEntity entity;

	@Mock
	DemographicDetailDto dto;

	@Mock
	EmergencyContactEntity emergencyEntity;
	@Mock
	PatientAllergyEntity patientAllergyEntity;

	@Test
	void testSave_UpdateDetail() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(entity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(entity.getDemographicDetailId()).thenReturn(JunitConstants.LONG_TYPE);

		when(entity.getEmergencyContactEntity()).thenReturn(emergencyEntity);
		when(emergencyEntity.getEmergencyContactId()).thenReturn(JunitConstants.LONG_TYPE);
		List<PatientAllergyEntity> patientAllergyList = new ArrayList<>();
		patientAllergyList.add(patientAllergyEntity);
		when(entity.getPatientAllergy()).thenReturn(patientAllergyList);
		when(patientAllergyEntity.getPatientAllergyId()).thenReturn(JunitConstants.LONG_TYPE);
		when(patientRepo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.save(dto));
	}

	@Test
	void testSave() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(entity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(patientRepo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.save(dto));

	}

	@Test
	void testGetpatientDetailbyUserId() throws CustomException {

		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.getpatientDetailbyUserId(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetpatientDetailbyUserId_CustomException() {
		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.getpatientDetailbyUserId(JunitConstants.LONG_TYPE));
		assertEquals( DemographicDetailsConstant.DEMOGRAPHIC_DETAIL_NOT_FOUND, customException.getMessage());
	}
}
