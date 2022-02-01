package com.pms.service;

import java.util.List;
import java.util.Set;

import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.PatientEntity;

public interface AllergyDetailsService {
	
	public List<AllergyDetailsEntity> getAllergybyId(AllergyDetailsEntity entity);
	public void save(AllergyDetailsEntity allergyDetailsEntity);
	public AllergyDetailsEntity getAllergyType(String type);
	public AllergyDetailsEntity getAllergyName(String allergyName);
}
