package com.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.EmergencyContactEntity;
import com.pms.entity.PatientBasicDetail;
import com.pms.repository.EmergencyDetailsRepo;
import com.pms.repository.PatientRepository;
@Service
public class EmergencyContactSeviceImpl implements EmergencyContactService{

	@Autowired
	private EmergencyDetailsRepo emergencyRepo;
	
	public EmergencyContactEntity save(EmergencyContactEntity emergencyContactEntity) {
	
		return emergencyRepo.save(emergencyContactEntity);
	}

	public EmergencyContactEntity getEmergencybyId(int emergencyId) {

		Optional<EmergencyContactEntity> optional = emergencyRepo.findById(emergencyId);
		EmergencyContactEntity emergencyContact = null;
		if (optional.isPresent()) {
			emergencyContact = optional.get();

		}
		return emergencyContact;

	}
	
	

}
