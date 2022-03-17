package com.pms.management.services;

import java.util.List;
import java.util.Optional;

import com.pms.management.dto.AllergyDto;
import com.pms.management.entites.AllergyEntity;




public interface AllergyService {
	
	public AllergyDto save(AllergyDto dto);
	
    public Optional<AllergyEntity> getAllergybyId(Long allergyId);
    
	public List<AllergyEntity> getAllergyDetails();
	
	public AllergyEntity getbyAllergyCode(String allergyCode);
	
	public List<AllergyDto>  getAllergyByListId(List<Long> id);
	
}