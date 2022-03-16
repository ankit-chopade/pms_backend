package com.pms.medication.service;

import java.util.List;

import com.pms.medication.dto.MedicationDto;
import com.pms.medication.utils.CustomException;

public interface MedicationService {
	
	public List<MedicationDto> getAllDetails(); 

	public MedicationDto saveMedication(MedicationDto dto) throws CustomException;

	public MedicationDto updateMedication(MedicationDto dto);

	public MedicationDto deleteMedication(Long id) throws CustomException;
}
