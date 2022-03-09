package com.pms.medication.service;

import java.util.List;

import com.pms.medication.dto.MedicationDto;
import com.pms.medication.utils.CustomException;

public interface MedicationService {
	
	public List<MedicationDto> getAllDetails(); 

	public MedicationDto saveDiagnosis(MedicationDto dto) throws CustomException;

	public MedicationDto updateDiagnosis(MedicationDto dto);

	public MedicationDto deleteDiagnosis(Long id) throws CustomException;
}
