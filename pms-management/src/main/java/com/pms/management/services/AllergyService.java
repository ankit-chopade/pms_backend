package com.pms.management.services;

import java.util.List;

import com.pms.management.dto.AllergyDto;


public interface AllergyService {
	
	public AllergyDto save(AllergyDto dto);

	public List<AllergyDto> getAllergyDetails();

	public AllergyDto getbyAllergyCode(String allergyCode);

	public List<AllergyDto> getByAllergyIdIn(List<Long> id);
}