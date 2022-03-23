package com.pms.allergy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.allergy.constant.JunitConstants;
import com.pms.allergy.constants.PmsAllergyConstants;
import com.pms.allergy.constants.PmsAllergyMsgConstants;
import com.pms.allergy.converter.AllergyConverter;
import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.entity.AllergyEntity;
import com.pms.allergy.repository.AllergyRepo;
import com.pms.allergy.utils.CustomException;

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
	AllergyDto dto;

	@Test
	void testGetAllDetails() {
		List<AllergyEntity> entityList = new ArrayList<>();
		List<AllergyDto> dtoList = new ArrayList<>();
		when(repository.findByActiveStatusOrderByCreatedDateDesc(PmsAllergyConstants.ACTIVE)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getAllDetails());
	}

	@Test
	void testSaveAllergy() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.findByAllergyCodeAndActiveStatus(dto.getAllergyCode(), PmsAllergyConstants.ACTIVE))
				.thenReturn(Optional.ofNullable(null));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.saveAllergy(dto));
	}

	@Test
	void testSaveAllergy_CustomException() throws CustomException {
		when(dto.getAllergyCode()).thenReturn(JunitConstants.STRING_TYPE);

		when(repository.findByAllergyCodeAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.saveAllergy(dto));
		assertEquals(PmsAllergyMsgConstants.ALLERGY_CODE_ALREADY_EXISTS, customException.getMessage());
	}

	@Test
	void testUpdateAllergy() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.updateAllergy(dto));
	}

	@Test
	void testDeleteAllergy() throws CustomException {
		when(repository.findByAllergyIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.deleteAllergy(JunitConstants.LONG_TYPE));
	}
	
	
	@Test
	void testDeleteAllergy_customException() throws CustomException {
		when(repository.findByAllergyIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.deleteAllergy(JunitConstants.LONG_TYPE));
		assertEquals(PmsAllergyMsgConstants.ALLERGY_DOES_NOT_EXISTS, customException.getMessage());
	}

}
