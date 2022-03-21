package com.pms.medication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.medication.constants.PmsMedicationConstants;
import com.pms.medication.constants.PmsMedicationMsgConstants;
import com.pms.medication.converter.MedicationConverter;
import com.pms.medication.dto.MedicationDto;
import com.pms.medication.entity.MedicationEntity;
import com.pms.medication.repository.MedicationRepository;
import com.pms.medication.utils.CustomException;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository repository;
	@Autowired
	private MedicationConverter converter;

	@Override
	public List<MedicationDto> getAllDetails() {
		List<MedicationEntity> medicationList = repository.findByActiveStatusOrderByCreatedDateDesc(PmsMedicationConstants.ACTIVE);
		return converter.toDto(medicationList);
	}

	@Override
	public MedicationDto saveMedication(MedicationDto dto) throws CustomException {
		MedicationEntity entity = converter.toEntity(dto);
		Optional<MedicationEntity> optional = repository.findByDrugIdAndActiveStatus(dto.getDrugId(),
				PmsMedicationConstants.ACTIVE);
		if (optional.isPresent()) {
			throw new CustomException(HttpStatus.CONFLICT, PmsMedicationMsgConstants.DRUG_ID_ALREADY_EXISTS);
		}
		entity.setActiveStatus(PmsMedicationConstants.ACTIVE);
		entity.setCreatedDate(new Date());
		MedicationEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);

	}

	@Override
	public MedicationDto updateMedication(MedicationDto dto) {
		MedicationEntity entity = converter.toEntity(dto);
		entity.setUpdatedDate(new Date());
		MedicationEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	@Override
	public MedicationDto deleteMedication(Long id) throws CustomException {
		Optional<MedicationEntity> optional = repository.findByMedicationIdAndActiveStatus(id,
				PmsMedicationConstants.ACTIVE);
		if (optional.isPresent()) {
			MedicationEntity entity = optional.get();
			entity.setActiveStatus(PmsMedicationConstants.DEACTIVE);
			entity.setUpdatedDate(new Date());
			MedicationEntity savedEntity = repository.save(entity);
			return converter.toDto(savedEntity);
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, PmsMedicationMsgConstants.MEDICATION_DOES_NOT_EXISTS);

		}
	}
}
