package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.MedicationConverter;
import com.pms.dto.MedicationDto;
import com.pms.entity.MedicationEntity;
import com.pms.entity.ProcedureEntity;
import com.pms.repository.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository repository;
	@Autowired
	private MedicationConverter converter;

	@Override
	public List<MedicationDto> getAllDetails() {
		List<MedicationEntity> medicationList = repository.findAll();
		return converter.toDto(medicationList);
	}

	@Override
	public MedicationDto saveDetails(MedicationDto dto) {
		MedicationEntity entity=converter.toEntity(dto);
		if(entity.getMedicationId()==null)
		{
			entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
			entity.setCreatedDate(new Date());
			MedicationEntity savedEntity = repository.save(entity);
			return converter.toDto(savedEntity);
		}
		else {
			Optional<MedicationEntity> optional= repository.findById(entity.getMedicationId());
			if(optional.isPresent()) {
				entity.setMedicationId(optional.get().getMedicationId());
				entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
				entity.setUpdatedDate(new Date());
				MedicationEntity savedEntity = repository.save(entity);
				return converter.toDto(savedEntity);
		}
	
		
	}
		return dto;
	}

	@Override
	public void delete(Long medicationId) {
		
		repository.deleteById(medicationId);
	}
}
