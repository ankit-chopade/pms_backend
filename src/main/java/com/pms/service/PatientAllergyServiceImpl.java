package com.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyEntity;
import com.pms.entity.PatientAllergyEntity;
import com.pms.repository.AllergyMapRepo;

@Service
public class PatientAllergyServiceImpl implements PatientAllergyService {

	@Autowired
	AllergyMapRepo repo;

	@Override
	public void saveAllergyMap(PatientAllergyEntity entity) {

		
		repo.save(entity);
	}

	@Override
	public boolean deleteAllergyMap(Integer allergyMapId) {
		Optional<PatientAllergyEntity> optional = repo.findById(allergyMapId);
		if (optional.isPresent()) 
		{		
		 repo.deleteById(allergyMapId);
		
		}
		
		 return true;
	}

	@Override
	public AllergyEntity deletePatientAllergy(Integer allergyId, Integer patientId) {
		return null;
	//	repo.findAll().stream().filter(patientAllergy ->patientAllergy.getAllergyId()
	}
	
	

}
