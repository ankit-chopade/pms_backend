package com.pms.management.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.AllergyConverter;
import com.pms.management.converter.DemographicDetailConverter;
import com.pms.management.dto.AllergyDto;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.AllergyEntity;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.entites.PatientAllergyEntity;
import com.pms.management.repository.AllergyRepo;
import com.pms.management.repository.DemographicDetailRepository;



@Service
public class DemographicDetailServiceImpl implements DemographicDetailService {

	@Autowired
	private DemographicDetailRepository patientRepo;

	@Autowired
	private AllergyRepo allergyRepo;
	
	@Autowired
	private DemographicDetailConverter converter;
	
	@Autowired
	private AllergyConverter allergyConverter;
	
	List<PatientAllergyEntity> allergy;

	public DemographicDetailDto save(DemographicDetailDto dto) {
		DemographicDetailEntity entity = converter.toEntity(dto);
		System.out.println("save Patient");
		// System.out.println(entity);
		Optional<DemographicDetailEntity> optional	=  patientRepo.findByUserId(entity.getUserId());
		if(optional.isPresent())
		{
			entity.setUpdatedBy(1l);
			entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			entity.setDemographicDetailId(optional.get().getDemographicDetailId());
			DemographicDetailEntity savedEntity= patientRepo.save(entity);
			return converter.toDto(savedEntity);
		}
		else {
			entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			entity.setCreatedBy(1l);
			DemographicDetailEntity savedEntity= patientRepo.save(entity);
		return converter.toDto(savedEntity);
		}
	}

	public DemographicDetailDto getpatientbyId(Long userid) {
		Optional<DemographicDetailEntity> optional = patientRepo.findByUserId(userid);
		DemographicDetailEntity patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		}
		return converter.toDto(patient);

	}

	@Override
	public List<AllergyEntity> getAllAllergy() {
	
		return 	allergyRepo.findAll();
	}

	@Override
	public AllergyDto save(AllergyDto dto) {
		AllergyEntity entity = allergyConverter.toEntity(dto);
		entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
		entity.setCreatedBy(1l);
		entity.setCreatedDate(new Date());
		AllergyEntity savedEntity = allergyRepo.save(entity);
		return allergyConverter.toDto(savedEntity);
	}

	
}
