package com.pms.service;

import java.util.Optional;

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
//		Optional<AllergyMapEntity> optional = repo.findById(entity.getAllergyMapId());
//		if (optional.isPresent()) {
//			
//			entity.setAllergyMapId(optional.get().getAllergyMapId()); 
//			 repo.save(entity);
//		}
//		else {
//			repo.save(entity);
//		}
		
		repo.save(entity);
	}

	@Override
	public boolean deleteAllergyMap(Integer allergyMapId) {
		Optional<AllergyMapEntity> optional = repo.findById(allergyMapId);
		if (optional.isPresent()) 
		{		
		 repo.deleteById(allergyMapId);
		
		}
		
		 return true;
	}
	
	

}
