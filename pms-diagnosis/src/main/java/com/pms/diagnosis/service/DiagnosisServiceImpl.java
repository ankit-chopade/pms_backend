package com.pms.diagnosis.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.diagnosis.constants.PmsDiagnosisConstants;
import com.pms.diagnosis.converter.DiagnosisConverter;
import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.entity.DiagnosisEntity;
import com.pms.diagnosis.repository.DiagnosisRepository;



@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository repository;

	@Autowired
	private DiagnosisConverter converter;

	@Override
	public DiagnosisDto saveDiagnosis(DiagnosisDto dto) {
		DiagnosisEntity entity = converter.toEntity(dto);
		entity.setActiveStatus(PmsDiagnosisConstants.ACTIVE_STATUS);
		entity.setCreatedDate(new Date());
		DiagnosisEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
}
