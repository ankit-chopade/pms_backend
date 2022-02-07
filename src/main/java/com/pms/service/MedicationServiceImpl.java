package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.MedicationConverter;
import com.pms.dto.MedicationDto;
import com.pms.entity.DiagnosisEntity;
import com.pms.entity.MedicationEntity;
import com.pms.repository.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository repository;
	@Autowired
	private MedicationConverter converter;

	@Override
	public MedicationDto getDetailsByCode(String code) {
		MedicationEntity entity = repository.findByDrugIdAndActiveStatus(code, PmsConstant.ACTIVE_STATUS);
		return converter.toDto(entity);
	}

	@Override
	public MedicationDto getDetailsByDescription(String description) {
		MedicationEntity entity = repository.findByDrugNameAndActiveStatus(description,
				PmsConstant.ACTIVE_STATUS);
		return converter.toDto(entity);
	}

	@Override
	public List<MedicationDto> getAllDetails() {
		List<MedicationEntity> medicationList = repository.findAll();
		return converter.toDto(medicationList);
	}
	
	

}
