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
	
	public void save(AllergyDetailsEntity allergyEntity) {
			allergyrepo.save(allergyEntity);
		
		
	}

	public List<AllergyDetailsEntity> getAllergybyId(AllergyDetailsEntity entity) {
		Optional<List<AllergyDetailsEntity>> optional = allergyrepo.findallergyDetailsId(entity.getAllergyDetailsId());
		List<AllergyDetailsEntity> allergy = null;
		if (optional.isPresent()) {
			allergy = (List<AllergyDetailsEntity>) optional.get();

		}
		return allergy;
	}



	public AllergyDetailsEntity getAllergyType(String type) {
		
		return allergyrepo.findByallergyType(type);
	}

	public AllergyDetailsEntity getAllergyName(String name) {
		
		return allergyrepo.findByallergyName(name);
	}
	
	public List<AllergyDetailsEntity> getAllergyDetails() {
		return allergyrepo.findAll();
	}


}
