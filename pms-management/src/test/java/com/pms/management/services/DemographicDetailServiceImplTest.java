package com.pms.management.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.pms.management.constant.JunitConstants;
import com.pms.management.constants.DemographicDetailsConstant;
import com.pms.management.converter.DemographicDetailConverter;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.repository.DemographicDetailRepository;
import com.pms.management.utils.CustomException;
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
	

//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}

	@Test
	void testSave() throws CustomException  {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(patientRepo.findByUserId(entity.getUserId())).thenReturn(Optional.ofNullable(null));
		when(patientRepo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.save(dto));
	}

	
//	@Test
//	void testSave_CustomException (){
//		when(converter.toEntity(dto)).thenReturn(entity);
//	}
	
	@Test
	void testGetpatientbyId() throws CustomException {
		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.getpatientDetailbyUserId(JunitConstants.LONG_TYPE));
	}
	@Test
	void testGetpatientbyId_CustomException() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(patientRepo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.getpatientDetailbyUserId(JunitConstants.LONG_TYPE));
		assertEquals(DemographicDetailsConstant.DEMOGRAPHIC_DETAIL_NOT_FOUND, customException.getMessage());
	}
}
