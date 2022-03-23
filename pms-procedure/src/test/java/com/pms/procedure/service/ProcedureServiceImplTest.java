package com.pms.procedure.service;

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

import com.pms.procedure.constants.JunitConstants;
import com.pms.procedure.constants.PmsProcedureMsgConstants;
import com.pms.procedure.converter.ProcedureConverter;
import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.entity.ProcedureEntity;
import com.pms.procedure.repository.ProcedureRepository;
import com.pms.procedure.utils.CustomException;

@ExtendWith(MockitoExtension.class)
class ProcedureServiceImplTest {

	@InjectMocks
	private ProcedureServiceImpl service;

	@Mock
	private ProcedureRepository repository;

	@Mock
	private ProcedureEntity entity;

	@Mock
	private ProcedureDto dto;

	@Mock
	private ProcedureConverter converter;

	@Test
	void testGetAllDetails() {
		List<ProcedureEntity> entityList = new ArrayList<>();
		List<ProcedureDto> dtoList = new ArrayList<>();
		when(repository.findByActiveStatusOrderByCreatedDateDesc(JunitConstants.INTEGER_TYPE)).thenReturn(entityList);
		when(converter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getAllDetails());
	}

	@Test
	void testSaveProcedure() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(dto.getProcedureCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findByProcedureCodeAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.saveProcedure(dto));

	}

	@Test
	void testSaveProcedure_customException() throws CustomException {
		when(dto.getProcedureCode()).thenReturn(JunitConstants.STRING_TYPE);

		when(repository.findByProcedureCodeAndActiveStatus(JunitConstants.STRING_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.saveProcedure(dto));
		assertEquals(PmsProcedureMsgConstants.PROCEDURE_CODE_ALREADY_EXISTS, customException.getMessage());

	}

	@Test
	void testUpdateProcedure() {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.updateProcedure(dto));

	}

	@Test
	void testDeleteProcedure() throws CustomException {
		when(repository.findByProcedureIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(dto);
		assertNotNull(service.deleteProcedure(JunitConstants.LONG_TYPE));

	}

	@Test
	void testDeleteProcedure_customException() throws CustomException {
		when(repository.findByProcedureIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.deleteProcedure(JunitConstants.LONG_TYPE));
		assertEquals(PmsProcedureMsgConstants.PROCEDURE_CODE_ALREADY_EXISTS, customException.getMessage());
	}
	@Test
	void testGetAllNonDepricatedDetails() {
		List<ProcedureEntity> list = new ArrayList<>();
		List<ProcedureDto> listDto = new ArrayList<>();
		when(repository.findByActiveStatusAndProcedureIsDepricated(JunitConstants.INTEGER_TYPE,
				JunitConstants.INTEGER_TYPE)).thenReturn(list);
		when(converter.toDto(list)).thenReturn(listDto);
		assertNotNull(service.getAllNonDepricatedDetails());
	}
}
