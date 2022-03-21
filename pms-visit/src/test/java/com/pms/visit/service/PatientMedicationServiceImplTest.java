package com.pms.visit.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.visit.constants.JunitConstants;
import com.pms.visit.converter.PatientMedicationConverter;
import com.pms.visit.dto.PatientMedicationDto;
import com.pms.visit.entity.PatientMedicationEntity;
import com.pms.visit.repository.PatientMedicationRepository;

@ExtendWith(MockitoExtension.class)
class PatientMedicationServiceImplTest {

	@InjectMocks
	private PatientMedicationServiceImpl service;
	
	@Mock
	private PatientMedicationRepository repository;
	
	@Mock
	private PatientMedicationConverter converter;
	
	@Mock
	private PatientMedicationEntity entity;
	
	@Mock 
	private PatientMedicationDto dto;
	
	@Test
	void testGetDetailByAppointmentId() {
		List<Object[]> list = new ArrayList<>();
		Object[] objArray = new Object[11];
		
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		objArray[2] = JunitConstants.STRING_TYPE;
		objArray[3] = JunitConstants.STRING_TYPE;
		objArray[4] = JunitConstants.STRING_TYPE;
		objArray[5] = JunitConstants.STRING_TYPE;
		objArray[6] = JunitConstants.STRING_TYPE;
		objArray[7] = JunitConstants.LONG_TYPE;
		objArray[8] = JunitConstants.STRING_TYPE;
		objArray[9] = JunitConstants.LONG_TYPE;
		objArray[10] = JunitConstants.STRING_TYPE;
		
		list.add(objArray);
		when(repository.findByAppointmentId(JunitConstants.LONG_TYPE)).thenReturn(list);
		assertNotNull(service.getDetailByAppointmentId(JunitConstants.LONG_TYPE));
	}

	@Test
	void testSavePatientMedication() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.savePatientMedication(dto));
	}

	@Test
	void testDeleteById() {
		service.deleteById(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(eq(JunitConstants.LONG_TYPE));
	}

}
