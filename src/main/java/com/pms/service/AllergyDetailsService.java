package com.pms.service;

import java.util.List;
import java.util.Optional;

import com.pms.dto.AllergyDto;
import com.pms.entity.AllergyEntity;

public interface AllergyDetailsService {
	

	
	public AllergyDto save(AllergyDto dto);
    public Optional<AllergyEntity> getAllergybyId(Integer allergyId);

	public AllergyEntity getAllergyType(String type);
	public AllergyEntity getAllergyName(String allergyName);
	public List<AllergyEntity> getAllergyDetails();
	public AllergyEntity getbyAllergyCode(String allergyCode);
	
	public void deleteallergy(Integer allergyId);
}