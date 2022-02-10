package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyIdEntity;
import com.pms.repository.AllergyIdRepo;

@Service
public class AllergyIdserviceImpl implements AllergyIdService {

	@Autowired
	AllergyIdRepo repo;
	
	public void saveAllergyId(AllergyIdEntity entity) {
		repo.save(entity);
		
	}

}
