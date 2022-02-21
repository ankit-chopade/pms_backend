package com.pms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyEntity;
import com.pms.entity.PatientBasicDetail;
import com.pms.repository.AllergyDetailsRepo;
@Service
public class AllergyDetailsServiceImpl implements AllergyDetailsService{
	@Autowired
	AllergyDetailsRepo allergyrepo;
	
	public AllergyEntity save(AllergyEntity allergyEntity) {
			return allergyrepo.save(allergyEntity);
		
	}

	public AllergyEntity getAllergyType(String type) {
		
		return allergyrepo.findByallergyType(type);
	}

	public AllergyEntity getAllergyName(String name) {
		
		return allergyrepo.findByallergyName(name);
	}
	
	public List<AllergyEntity> getAllergyDetails() {
		System.out.println(allergyrepo.findAll());
		return allergyrepo.findAll();
	}


	@Override
	public Optional<AllergyEntity> getAllergybyId(Integer id) {
		System.out.println(allergyrepo.findById(id));
		return allergyrepo.findById(id);
	}

	@Override
	public AllergyEntity getbyAllergyCode(String allergyCode) {
		
		return allergyrepo.findByAllergyCode(allergyCode);
	}


}
