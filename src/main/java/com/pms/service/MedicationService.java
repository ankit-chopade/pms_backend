package com.pms.service;

import java.util.List;

import com.pms.dto.MedicationDto;

public interface MedicationService {

	public MedicationDto getDetailsByCode(String code);

	public MedicationDto getDetailsByDescription(String description);
	
	public List<MedicationDto> getAllDetails(); 

}
