package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.converter.MedicationConverter;
import com.pms.dto.MedicationDto;
import com.pms.entity.MedicationEntity;
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
}
