package com.pms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.pms.entity.AllergyEntity;
import com.pms.entity.PatientBasicDetail;

public interface AllergyDetailsService {
	

	
	public AllergyEntity save(AllergyEntity allergyDetailsEntity);
    public Optional<AllergyEntity> getAllergybyId(Integer allergyId);

	public AllergyEntity getAllergyType(String type);
	public AllergyEntity getAllergyName(String allergyName);
	public List<AllergyEntity> getAllergyDetails();
	public AllergyEntity getbyAllergyCode(String allergyCode);
}
