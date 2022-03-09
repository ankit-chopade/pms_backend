package com.pms.allergy.service;

import java.util.List;
import java.util.Optional;

import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.entity.AllergyEntity;



public interface AllergyService {
	

	
	public AllergyDto save(AllergyDto dto);
    public Optional<AllergyEntity> getAllergybyId(Long allergyId);
	public List<AllergyEntity> getAllergyDetails();
	public AllergyEntity getbyAllergyCode(String allergyCode);
	public void deleteAllergy(Long allergyId);
}