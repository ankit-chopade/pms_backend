package com.pms.service;

import java.util.List;

import com.pms.dto.DiagnosisDto;

public interface DiagnosisService {

	public List<DiagnosisDto> getAllDetails(); 
	
	public DiagnosisDto saveDiagnosis(DiagnosisDto dto);
    
	public void deleteDiagnosis(Long diagnosisId);

}
