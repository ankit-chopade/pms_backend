package com.pms.service;

import java.util.List;

import com.pms.dto.DiagnosisDto;
import com.pms.dto.IdNameDto;

public interface DiagnosisService {

	public DiagnosisDto getDetailsByCode(String code);

	public List<IdNameDto> getDetailsByDescription(String description);
	
	public List<DiagnosisDto> getAllDetails(); 

}
