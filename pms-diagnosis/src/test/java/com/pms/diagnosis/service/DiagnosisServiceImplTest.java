package com.pms.diagnosis.service;

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

import com.pms.diagnosis.constants.JunitConstants;
import com.pms.diagnosis.constants.PmsDiagnosisMsgConstants;
import com.pms.diagnosis.converter.DiagnosisConverter;
import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.entity.DiagnosisEntity;
import com.pms.diagnosis.repository.DiagnosisRepository;
import com.pms.diagnosis.utils.CustomException;

@ExtendWith(MockitoExtension.class)
class DiagnosisServiceImplTest {

	@InjectMocks
	private DiagnosisServiceImpl service;

	@Mock
	private DiagnosisRepository repository;

	@Mock
	private DiagnosisEntity entity;

	@Mock
	private DiagnosisDto dto;

	@Mock
	private DiagnosisConverter converter;

	@Test
	void testGetAllDetails() {
		List<DiagnosisEntity> entityList = new ArrayList<>();
		List<DiagnosisDto> dtoList = new ArrayList<>();
		when(repository.findByActiveStatusOrderByCreatedDateDesc(JunitConstants.INTEGER_TYPE)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getAllDetails());
	}

	@Test
	void testSaveDiagnosis() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(dto.getDiagnosisCode()).thenReturn(JunitConstants.STRING_TYPE);

		when(repository.findByDiagnosisCodeAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.saveDiagnosis(dto));

	}

	@Test
	void testSaveDiagnosis_customException() throws CustomException {
		when(dto.getDiagnosisCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.findByDiagnosisCodeAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.saveDiagnosis(dto));
		assertEquals(PmsDiagnosisMsgConstants.DIAGNOSIS_CODE_ALREADY_EXISTS, customException.getMessage());

	}

	@Test
	void testUpdateDiagnosis() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.updateDiagnosis(dto));

	}

	@Test
	void testDeleteDiagnosis() throws CustomException {
		when(repository.findByDiagnosisIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.deleteDiagnosis(JunitConstants.LONG_TYPE));

	}

	@Test
	void testDeleteDiagnosis_customException() throws CustomException {
		when(repository.findByDiagnosisIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.deleteDiagnosis(JunitConstants.LONG_TYPE));
		assertEquals(PmsDiagnosisMsgConstants.DIAGNOSIS_DOES_NOT_EXISTS, customException.getMessage());
	}

	@Test
	void testGetAllNonDepricatedDetails() {
		List<DiagnosisEntity> list = new ArrayList<>();
		List<DiagnosisDto> listDto = new ArrayList<>();
		when(repository.findByActiveStatusAndDiagnosisIsDepricated(JunitConstants.INTEGER_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(list);
		when(converter.toDto(list)).thenReturn(listDto);
		assertNotNull(service.getAllNonDepricatedDetails());
	}

}
