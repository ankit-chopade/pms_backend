package com.pms.diagnosis.service;

import java.util.List;

import com.pms.diagnosis.dto.DiagnosisDto;
import com.pms.diagnosis.utils.CustomException;

public interface DiagnosisService {

	public List<DiagnosisDto> getAllDetails();

	public DiagnosisDto saveDiagnosis(DiagnosisDto dto) throws CustomException;

	public DiagnosisDto updateDiagnosis(DiagnosisDto dto);

	public DiagnosisDto deleteDiagnosis(Long id) throws CustomException;
	
	public List<DiagnosisDto> getAllNonDepricatedDetails();

}
