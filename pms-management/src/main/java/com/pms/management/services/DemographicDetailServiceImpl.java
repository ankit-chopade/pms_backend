package com.pms.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.management.constants.DemographicDetailsConstant;
import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.DemographicDetailConverter;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;
import com.pms.management.entites.EmergencyContactEntity;
import com.pms.management.entites.PatientAllergyEntity;
import com.pms.management.repository.DemographicDetailRepository;
import com.pms.management.utils.CustomException;

@Service
public class DemographicDetailServiceImpl implements DemographicDetailService {

	@Autowired
	private DemographicDetailRepository patientRepo;

	@Autowired
	private DemographicDetailConverter converter;

	public DemographicDetailDto save(DemographicDetailDto dto) {
		DemographicDetailEntity entity = converter.toEntity(dto);
		Optional<DemographicDetailEntity> optional = patientRepo.findByUserId(entity.getUserId());
		EmergencyContactEntity emergencyEntity;
		List<PatientAllergyEntity> patientAllergyList;
		if (optional.isPresent()) {
			entity.setUpdatedBy(1l);
			entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			entity.setDemographicDetailId(optional.get().getDemographicDetailId());
			emergencyEntity = entity.getEmergencyContactEntity();
			emergencyEntity.setEmergencyContactId(optional.get().getEmergencyContactEntity().getEmergencyContactId());
			patientAllergyList = entity.getPatientAllergy();
			for (PatientAllergyEntity listPatientAllergy : patientAllergyList) {

				for (PatientAllergyEntity patientAllergy : patientAllergyList) {
					Long id = patientAllergy.getPatientAllergyId();
					listPatientAllergy.setPatientAllergyId(id);
				}
			}
			entity.setEmergencyContactEntity(emergencyEntity);
			DemographicDetailEntity savedEntity = patientRepo.save(entity);
			return converter.toDto(savedEntity);
		} else {
			entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
			entity.setCreatedBy(1l);
			DemographicDetailEntity savedEntity = patientRepo.save(entity);
			return converter.toDto(savedEntity);
		}
	}

	public DemographicDetailDto getpatientDetailbyUserId(Long userid) throws CustomException {
		Optional<DemographicDetailEntity> optional = patientRepo.findByUserId(userid);
		DemographicDetailEntity patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
			return converter.toDto(patient);
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND,  DemographicDetailsConstant.DEMOGRAPHIC_DETAIL_NOT_FOUND);
		}

	}

}
