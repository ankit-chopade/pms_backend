package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.common.util.ResponseUtil;
import com.pms.entity.AllergyDetailsEntity;
import com.pms.entity.AllergyIdEntity;
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
	
	@Autowired
	AllergyIdService allergyIdService;
	
	List<AllergyIdEntity> allergy;
	
	public Boolean save(PatientEntity patientEntity) {
	
	System.out.println("save Patient");
		PatientEntity  savePatient= patientRepo.save(patientEntity);
		emergencyservice.save(patientEntity.getEmergencyContactEntity());
		 for(AllergyIdEntity allergyid : patientEntity.getAllergyDetailsId())
		 {
			 System.out.println(allergyid+"allergyId");
			 allergyIdService.saveAllergyId(allergyid);
		 }
		
//		  for(AllergyDetailsEntity allergy:patientEntity.getAllergyDetailsEntity())
//		  {
//			  allergeyDetailsservice.save(allergy);
//		  }
		return true;
		
	}

	public PatientEntity getpatientbyId(Integer userid) {
		Optional<PatientEntity> optional= patientRepo.findByUserId(userid);	
		PatientEntity patient = null;
		if (optional.isPresent()) {
			patient = optional.get();

		}
		return patient;

	}
}
