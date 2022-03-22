package com.pms.management.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.management.constant.JunitConstants;
import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.AllergyConverter;
import com.pms.management.dto.AllergyDto;
import com.pms.management.entites.AllergyEntity;
import com.pms.management.repository.AllergyRepo;
@ExtendWith(MockitoExtension.class)
class AllergyServiceImplTest {
	
	@InjectMocks
	AllergyServiceImpl service;

	@Mock
	private AllergyRepo repository;

	@Mock
	private AllergyConverter converter;

	@Mock
	AllergyEntity entity;
	@Mock
	List<AllergyEntity> entityList;
	
	@Mock
	AllergyDto dto;
	@Mock
	List<AllergyDto> dtoList;

	@Test
	void testSave() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.save(dto));
	}

	@Test
	void testGetAllergyDetails() {
		List<AllergyEntity> entityList = new ArrayList<>();
		List<AllergyDto> dtoList = new ArrayList<>();
		when(repository.findByActiveStatus(ManagementConstants.ACTIVE_STATUS)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getAllergyDetails());
	}

	@Test
	void testGetbyAllergyCode() {
		when(repository.findByAllergyCode(JunitConstants.STRING_TYPE)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.getbyAllergyCode(JunitConstants.STRING_TYPE));
	}

	@Test
	void testGetByAllergyIdIn() {
		when(repository.findByAllergyIdIn(JunitConstants.LIST_LONG_TYPE)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getByAllergyIdIn(JunitConstants.LIST_LONG_TYPE));
	}

}
