package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.common.util.ResponseUtil;
import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.PatientEntity;
import com.pms.entity.UserEntity;
import com.pms.repository.PatientRepository;
import com.pms.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	EmergencyContactService emergencyservice;
	
	@Autowired
	AllergyDetailsService allergeyDetailsservice;
	List<AllergyDetailsEntity> allergy;
	
	public Boolean save(PatientEntity patientEntity) {
	
	
		PatientEntity  savePatient= patientRepo.save(patientEntity);
		emergencyservice.save(patientEntity.getEmergencyContactEntity());
		  for(AllergyDetailsEntity allergy:patientEntity.getAllergyDetailsEntity())
		  {
			  allergeyDetailsservice.save(allergy);
		  }
		return true;
		
	}

	public PatientEntity getpatientbyId(Integer patientId) {
		Optional<PatientEntity> optional = patientRepo.findById(patientId);
		PatientEntity patient = null;
		if (optional.isPresent()) {
			patient = optional.get();

		}
		return patient;

	}
}
