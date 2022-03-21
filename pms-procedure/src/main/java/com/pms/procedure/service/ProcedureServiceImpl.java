package com.pms.procedure.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.procedure.constants.PmsProcedureConstants;
import com.pms.procedure.constants.PmsProcedureMsgConstants;
import com.pms.procedure.converter.ProcedureConverter;
import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.entity.ProcedureEntity;
import com.pms.procedure.repository.ProcedureRepository;
import com.pms.procedure.utils.CustomException;

@Service
public class ProcedureServiceImpl implements ProcedureService {

	@Autowired
	private ProcedureRepository repository;

	@Autowired
	private ProcedureConverter converter;

	@Override
	public List<ProcedureDto> getAllDetails() {
		List<ProcedureEntity> procedureList = repository.findByActiveStatusOrderByCreatedDateDesc(PmsProcedureConstants.ACTIVE);
		return converter.toDto(procedureList);
	}

	@Override
	public ProcedureDto saveProcedure(ProcedureDto dto) throws CustomException {
		ProcedureEntity entity = converter.toEntity(dto);
		Optional<ProcedureEntity> optional = repository.findByProcedureCodeAndActiveStatus(dto.getProcedureCode(),
				PmsProcedureConstants.ACTIVE);
		if (optional.isPresent()) {
			throw new CustomException(HttpStatus.CONFLICT, PmsProcedureMsgConstants.PROCEDURE_CODE_ALREADY_EXISTS);
		}
		entity.setActiveStatus(PmsProcedureConstants.ACTIVE);
		entity.setCreatedDate(new Date());
		ProcedureEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	@Override
	public ProcedureDto updateProcedure(ProcedureDto dto)  {
		ProcedureEntity entity = converter.toEntity(dto);
		entity.setUpdatedDate(new Date());
		ProcedureEntity updatedEntity = repository.save(entity);
		return converter.toDto(updatedEntity);
	}

	@Override
	public ProcedureDto deleteProcedure(Long id) throws CustomException {
		Optional<ProcedureEntity> optional = repository.findByProcedureIdAndActiveStatus(id, PmsProcedureConstants.ACTIVE);
		if (optional.isPresent()) {
			ProcedureEntity entity = optional.get();
			entity.setActiveStatus(PmsProcedureConstants.DEACTIVE);
			ProcedureEntity updatedEntity = repository.save(entity);
			return converter.toDto(updatedEntity);
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, PmsProcedureMsgConstants.PROCEDURE_CODE_ALREADY_EXISTS);
		}
	}
	
	@Override
	public List<ProcedureDto> getAllNonDepricatedDetails() {
		List<ProcedureEntity> procedureList = repository.findByActiveStatusAndProcedureIsDepricated(PmsProcedureConstants.ACTIVE, 
				PmsProcedureConstants.IS_DEPRICATED);
		return converter.toDto(procedureList);
	}

}
