package com.pms.medication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.medication.converter.MedicationConverter;
import com.pms.medication.dto.MedicationDto;
import com.pms.medication.entity.MedicationEntity;
import com.pms.medication.repository.MedicationRepository;

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
