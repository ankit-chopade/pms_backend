package com.pms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.PatientEntity;
import com.pms.repository.AllergyDetailsRepo;
@Service
public class AllergyDetailsServiceImpl implements AllergyDetailsService{
	@Autowired
	AllergyDetailsRepo allergyrepo;
	
	public void save(Set<AllergyDetailsEntity>  allergyEntity) {
		for(AllergyDetailsEntity allergyEntity1:allergyEntity)
		{
			allergyrepo.save(allergyEntity1);
		}
		
	}

	public AllergyDetailsEntity getAllergybyId(AllergyDetailsEntity entity) {
		Optional<AllergyDetailsEntity> optional = allergyrepo.findById(entity.getAllergyDetailsId());
		AllergyDetailsEntity allergy = null;
		if (optional.isPresent()) {
			allergy = optional.get();

		}
		return allergy;
	}

	public AllergyDetailsEntity getAllergyType(String type) {
		
		return allergyrepo.findByallergyType(type);
	}

	public AllergyDetailsEntity getAllergyName(String name) {
		
		return allergyrepo.findByallergyName(name);
	}



}
