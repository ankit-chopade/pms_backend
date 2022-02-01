package com.pms.service;

import java.util.List;
import java.util.Set;

import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.PatientEntity;

public interface AllergyDetailsService {
	
//	public AllergyDetailsEntity getAllergybyId(AllergyDetailsEntity entity);
	public void save(Set<AllergyDetailsEntity> set);
	public AllergyDetailsEntity getAllergyType(String type);
	public AllergyDetailsEntity getAllergyName(String allergyName);
	public List<AllergyDetailsEntity> getAllergyDetails();
}
