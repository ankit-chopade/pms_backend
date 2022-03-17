package com.pms.allergy.service;

import java.util.List;

import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.utils.CustomException;

public interface AllergyService {


	
	public List<AllergyDto> getAllDetails();

	public AllergyDto saveAllergy(AllergyDto dto) throws CustomException;
	
	public AllergyDto updateAllergy(AllergyDto dto) throws CustomException;
	
	public AllergyDto deleteAllergy(Long id) throws CustomException;
}