package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.DiagnosisConverter;
import com.pms.dto.DiagnosisDto;
import com.pms.entity.DiagnosisEntity;
import com.pms.repository.DiagnosisRepository;
import java.util.Optional;
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository repository;

	@Autowired
	private DiagnosisConverter converter;

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
		System.out.println(entity.getDiagnosisId());
		if(entity.getDiagnosisId()==null)
		{
			entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
			entity.setCreatedDate(new Date());
			DiagnosisEntity savedEntity = repository.save(entity);
			return converter.toDto(savedEntity);
		}
		else {
			Optional<DiagnosisEntity> optional= repository.findById(entity.getDiagnosisId());
			if(optional.isPresent()) {
				entity.setDiagnosisId(optional.get().getDiagnosisId());
				entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
				entity.setUpdatedDate(new Date());
				DiagnosisEntity savedEntity = repository.save(entity);
				return converter.toDto(savedEntity);
			}
		}
		return dto;
		
		
		
	}

	@Override
	public void deleteDiagnosis(Long diagnosisId) {
		repository.deleteById(diagnosisId);
//		DiagnosisEntity entity = converter.toEntity(dto);
//		Optional<DiagnosisEntity> optional= repository.findById(entity.getDiagnosisId());
//		if(optional.isPresent()) {
//			 repository.deleteById(optional.get().getDiagnosisId());
//		}	
	}
}
