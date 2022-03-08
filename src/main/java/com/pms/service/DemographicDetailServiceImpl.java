package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.PatientAllergyEntity;
import com.pms.entity.DemographicDetail;
import com.pms.repository.AllergyMapRepo;
import com.pms.repository.PatientRepository;

@Service
public class DemographicDetailServiceImpl implements DemographicDetailService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	EmergencyContactService emergencyservice;

	@Autowired
	PatientAllergyService allergyMapService;

	@Autowired
	AllergyMapRepo allergyMapRepo;

	List<PatientAllergyEntity> allergy;

	public DemographicDetail save(DemographicDetail patientEntity) {
		System.out.println("save Patient");
		 System.out.println(patientEntity);
		Optional<DemographicDetail> optional	=  patientRepo.findByUserId(patientEntity.getUserId());
		if(optional.isPresent())
		{
		//	patientEntity.setUpdatedBy(1l);
			patientEntity.setDemographicDetailId(optional.get().getDemographicDetailId());
			return patientRepo.save(patientEntity);
		}
		else {
		//	patientEntity.setCreatedBy(1l);
		return patientRepo.save(patientEntity);
		}
	}

	public DemographicDetail getpatientbyId(Integer userid) {
		Optional<DemographicDetail> optional = patientRepo.findByUserId(userid);
		DemographicDetail patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		}
		return patient;

	}
}
