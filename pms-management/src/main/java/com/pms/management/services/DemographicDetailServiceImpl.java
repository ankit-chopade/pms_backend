package com.pms.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.management.converter.DemographicDetailConverter;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.entites.PatientAllergyEntity;
import com.pms.management.repository.DemographicDetailRepository;



@Service
public class DemographicDetailServiceImpl implements DemographicDetailService {

	@Autowired
	private DemographicDetailRepository patientRepo;

	@Autowired
	private DemographicDetailConverter converter;
	

	List<PatientAllergyEntity> allergy;

	public DemographicDetailDto save(DemographicDetailDto dto) {
		DemographicDetailEntity entity = converter.toEntity(dto);
		System.out.println("save Patient");
		// System.out.println(entity);
		Optional<DemographicDetailEntity> optional	=  patientRepo.findByUserId(entity.getUserId());
		if(optional.isPresent())
		{
			entity.setUpdatedBy(1l);
			entity.setDemographicDetailId(optional.get().getDemographicDetailId());
			DemographicDetailEntity savedEntity= patientRepo.save(entity);
			return converter.toDto(savedEntity);
		}
		else {
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

	
}
