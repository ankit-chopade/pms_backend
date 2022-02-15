package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.converter.ProcedureConverter;
import com.pms.dto.ProcedureDto;
import com.pms.entity.ProcedureEntity;
import com.pms.repository.ProcedureRepository;

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

	@Override
	public void deleteById(Long patientProcedureId) {
		repository.deleteById(patientProcedureId);
	}
	
	

}
