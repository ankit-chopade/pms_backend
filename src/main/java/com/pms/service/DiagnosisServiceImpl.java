package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.DiagnosisConverter;
import com.pms.dto.DiagnosisDto;
import com.pms.dto.IdNameDto;
import com.pms.entity.DiagnosisEntity;
import com.pms.repository.DiagnosisRepository;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository repository;

	@Autowired
	private DiagnosisConverter converter;

	@Override
	public DiagnosisDto getDetailsByCode(String code) {
		DiagnosisEntity entity = repository.findByDiagnosisCodeAndActiveStatus(code, PmsConstant.ACTIVE_STATUS);
		return converter.toDto(entity);
	}

	@Override
	public List<IdNameDto> getDetailsByDescription(String description) {
		List<DiagnosisEntity> diagnosisList = repository.findByDiagnosisDescriptionAndActiveStatus(description,
				PmsConstant.ACTIVE_STATUS);
		return diagnosisList.stream().map(d -> new IdNameDto(d.getDiagnosisId(), d.getDiagnosisDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public List<DiagnosisDto> getAllDetails() {
		List<DiagnosisEntity> diagnosisList = repository.findAll();
		List<DiagnosisEntity> diagnosisFilteredList = diagnosisList.stream()
				.filter(d -> d.getDiagnosisDescription() != "Others").collect(Collectors.toList());
		return converter.toDto(diagnosisFilteredList);
	}

	@Override
	public DiagnosisDto saveDiagnosis(DiagnosisDto dto) {
		DiagnosisEntity entity = converter.toEntity(dto);
		entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		DiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
}
