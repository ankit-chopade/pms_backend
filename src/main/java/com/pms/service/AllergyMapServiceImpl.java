package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyMapEntity;
import com.pms.repository.AllergyMapRepo;

@Service
public class AllergyMapServiceImpl implements AllergyMapService {

	@Autowired
	AllergyMapRepo repo;

	@Override
	public void saveAllergyMap(AllergyMapEntity entity) {
		repo.save(entity);
		
	}
	
	

}
