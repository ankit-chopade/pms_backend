package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.common.util.ResponseUtil;
import com.pms.entity.AllergyEntity;
import com.pms.entity.AllergyMapEntity;
import com.pms.entity.PatientBasicDetail;
import com.pms.entity.UserEntity;
import com.pms.repository.AllergyMapRepo;
import com.pms.repository.PatientRepository;
import com.pms.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientBasicDetailService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	EmergencyContactService emergencyservice;

	@Autowired
	AllergyMapService allergyMapService;

	@Autowired
	AllergyMapRepo allergyMapRepo;

	List<AllergyMapEntity> allergy;

	public Boolean save(PatientBasicDetail patientEntity) {
		System.out.println("save Patient");
		PatientBasicDetail savePatient = patientRepo.save(patientEntity);
		emergencyservice.save(patientEntity.getEmergencyContactEntity());
		for (AllergyMapEntity allergyMapEntity : patientEntity.getAllergyMap()) {
			allergyMapService.saveAllergyMap(allergyMapEntity);
		}
		return true;
	}

	public PatientBasicDetail getpatientbyId(Integer userid) {
		Optional<PatientBasicDetail> optional = patientRepo.findByUserId(userid);
		PatientBasicDetail patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		}
		return patient;

	}
}
