package com.pms.medication.service;

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

import com.pms.medication.constants.JunitConstants;
import com.pms.medication.constants.PmsMedicationMsgConstants;
import com.pms.medication.converter.MedicationConverter;
import com.pms.medication.dto.MedicationDto;
import com.pms.medication.entity.MedicationEntity;
import com.pms.medication.repository.MedicationRepository;
import com.pms.medication.utils.CustomException;

@ExtendWith(MockitoExtension.class)
class MedicationServiceImplTest {

	@InjectMocks
	private MedicationServiceImpl service;

	@Mock
	private MedicationRepository repository;

	@Mock
	private MedicationEntity entity;

	@Mock
	private MedicationDto dto;

	@Mock
	private MedicationConverter converter;

	@Test
	void testGetAllDetails() {
		List<MedicationEntity> entityList = new ArrayList<>();
		List<MedicationDto> dtoList = new ArrayList<>();
		when(repository.findByActiveStatusOrderByCreatedDateDesc(JunitConstants.INTEGER_TYPE)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getAllDetails());
	}

	@Test
	void testSaveMedication() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(dto.getDrugId()).thenReturn(JunitConstants.STRING_TYPE);

		when(repository.findByDrugIdAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.saveMedication(dto));

	}

	@Test
	void testSaveMedication_customException() throws CustomException {
		when(dto.getDrugId()).thenReturn(JunitConstants.STRING_TYPE);

		when(repository.findByDrugIdAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.saveMedication(dto));
		assertEquals(PmsMedicationMsgConstants.DRUG_ID_ALREADY_EXISTS, customException.getMessage());

	}

	@Test
	void testUpdateMedication() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.updateMedication(dto));

	}

	@Test
	void testDeleteMedication() throws CustomException {
		when(repository.findByMedicationIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.deleteMedication(JunitConstants.LONG_TYPE));

	}

	@Test
	void testDeleteMedication_customException() throws CustomException {
		when(repository.findByMedicationIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.deleteMedication(JunitConstants.LONG_TYPE));
		assertEquals(PmsMedicationMsgConstants.MEDICATION_DOES_NOT_EXISTS, customException.getMessage());
	}
}
