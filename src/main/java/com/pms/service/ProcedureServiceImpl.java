package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.ProcedureConverter;
import com.pms.dto.ProcedureDto;
import com.pms.entity.DiagnosisEntity;
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
	public ProcedureDto saveProcedure(ProcedureDto dto) {
		ProcedureEntity entity=converter.toEntity(dto);
		if(entity.getProcedureId()==null)
		{
			entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
			entity.setCreatedDate(new Date());
			ProcedureEntity savedEntity = repository.save(entity);
			return converter.toDto(savedEntity);
		}
		else {
			Optional<ProcedureEntity> optional= repository.findById(entity.getProcedureId());
			if(optional.isPresent()) {
				entity.setProcedureId(optional.get().getProcedureId());
				entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
				entity.setUpdatedDate(new Date());
				ProcedureEntity savedEntity = repository.save(entity);
				return converter.toDto(savedEntity);
		}
	
		
	}
		return dto;

}

	@Override
	public void deleteProcedure(Long procedureId) {
		repository.deleteById(procedureId);
		
	}
	
	
	
}
