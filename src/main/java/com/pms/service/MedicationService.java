package com.pms.service;

import java.util.List;

import com.pms.dto.MedicationDto;

public interface MedicationService {
	
	public List<MedicationDto> getAllDetails(); 
	public MedicationDto saveDetails(MedicationDto dto); 
	public void delete(Long medicationId);
}
