package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.AllergyMapEntity;
import com.pms.entity.PatientBasicDetail;
import com.pms.repository.AllergyMapRepo;
import com.pms.repository.PatientRepository;

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

	public PatientBasicDetail save(PatientBasicDetail patientEntity) {
		System.out.println("save Patient");
		 System.out.println(patientEntity);
		Optional<PatientBasicDetail> optional	=  patientRepo.findByUserId(patientEntity.getUserId());
		if(optional.isPresent())
		{
			patientEntity.setPatientBasicDetailId(optional.get().getPatientBasicDetailId());	
			return patientRepo.save(patientEntity);
		}
		else {
		return patientRepo.save(patientEntity);
		}
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
