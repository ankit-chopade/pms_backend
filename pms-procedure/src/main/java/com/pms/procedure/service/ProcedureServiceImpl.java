package com.pms.procedure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.procedure.converter.ProcedureConverter;
import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.entity.ProcedureEntity;
import com.pms.procedure.repository.ProcedureRepository;

@Service
public class ProcedureServiceImpl implements ProcedureService {

	@Autowired
	private ProcedureRepository repository;

	@Autowired
	private ProcedureConverter converter;

	@Override
	public List<ProcedureDto> getAllDetails() {
		List<ProcedureEntity> procedureList = repository.findAll();
		return converter.toDto(procedureList);
	}

}
