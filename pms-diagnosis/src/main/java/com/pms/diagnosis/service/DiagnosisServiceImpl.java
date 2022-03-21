package com.pms.diagnosis.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.diagnosis.constants.PmsDiagnosisConstants;
import com.pms.diagnosis.constants.PmsDiagnosisMsgConstants;
import com.pms.diagnosis.converter.DiagnosisConverter;
import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.entity.DiagnosisEntity;
import com.pms.diagnosis.repository.DiagnosisRepository;
import com.pms.diagnosis.utils.CustomException;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository repository;

	@Autowired
	private DiagnosisConverter converter;

	@Override
	public List<DiagnosisDto> getAllDetails() {
		List<DiagnosisEntity> diagnosisList = repository.findByActiveStatusOrderByCreatedDateDesc(PmsDiagnosisConstants.ACTIVE);
		return converter.toDto(diagnosisList);
	}

	@Override
	public DiagnosisDto saveDiagnosis(DiagnosisDto dto) throws CustomException {
		DiagnosisEntity entity = converter.toEntity(dto);
		Optional<DiagnosisEntity> optional = repository.findByDiagnosisCodeAndActiveStatus(dto.getDiagnosisCode(),
				PmsDiagnosisConstants.ACTIVE);
		if (optional.isPresent()) {
			throw new CustomException(HttpStatus.CONFLICT, PmsDiagnosisMsgConstants.DIAGNOSIS_CODE_ALREADY_EXISTS);
		}
		entity.setActiveStatus(PmsDiagnosisConstants.ACTIVE);
		entity.setCreatedDate(new Date());
		DiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	@Override
	public DiagnosisDto updateDiagnosis(DiagnosisDto dto) {
		DiagnosisEntity entity = converter.toEntity(dto);
		entity.setUpdatedDate(new Date());
		DiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	@Override
	public DiagnosisDto deleteDiagnosis(Long id) throws CustomException {
		Optional<DiagnosisEntity> optional = repository.findByDiagnosisIdAndActiveStatus(id,
				PmsDiagnosisConstants.ACTIVE);
		if (optional.isPresent()) {
			DiagnosisEntity entity = optional.get();
			entity.setActiveStatus(PmsDiagnosisConstants.DEACTIVE);
			entity.setUpdatedDate(new Date());
			DiagnosisEntity savedEntity = repository.save(entity);
			return converter.toDto(savedEntity);
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, PmsDiagnosisMsgConstants.DIAGNOSIS_DOES_NOT_EXISTS);

		}

	}
	
	@Override
	public List<DiagnosisDto> getAllNonDepricatedDetails() {
		List<DiagnosisEntity> diagnosisList = repository.findByActiveStatusAndDiagnosisIsDepricated(PmsDiagnosisConstants.ACTIVE, 
				PmsDiagnosisConstants.IS_DEPRICATED);
		return converter.toDto(diagnosisList);
	}
}
