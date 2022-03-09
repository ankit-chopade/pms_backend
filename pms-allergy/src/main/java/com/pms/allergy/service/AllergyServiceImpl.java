package com.pms.allergy.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pms.allergy.constants.PmsAllergyConstants;
import com.pms.allergy.constants.PmsAllergyMsgConstants;
import com.pms.allergy.converter.AllergyConverter;
import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.entity.AllergyEntity;
import com.pms.allergy.repository.AllergyRepo;
import com.pms.allergy.utils.CustomException;

@Service
public class AllergyServiceImpl implements AllergyService{
	
	@Autowired
	private AllergyRepo repository;
	
	@Autowired
	private AllergyConverter converter;
	
	@Override
	public List<AllergyDto> getAllDetails() {
		List<AllergyEntity> allergyList = repository.findByActiveStatus(PmsAllergyConstants.ACTIVE);
		return converter.toDto(allergyList);
	}
	
//	@Override
//	public AllergyDto saveAllergy(AllergyDto dto) {
//			AllergyEntity entity = converter.toEntity(dto);
//	
//			if(entity.getAllergyId()==null)
//			{
//			  entity.setActiveStatus(PmsAllergyConstants.ACTIVE);
//				entity.setCreatedBy(1l);
//				entity.setCreatedDate(new Date());
//				AllergyEntity savedEntity = allergyrepo.save(entity);
//				return converter.toDto(savedEntity);
//			}
//			else {
//				Optional<AllergyEntity> optional= allergyrepo.findById(entity.getAllergyId());
//				if(optional.isPresent()) {
//					entity.setAllergyId(optional.get().getAllergyId());
//					entity.setUpdatedDate(new Date());
//					entity.setUpdatedBy(1l);
//					entity.setActiveStatus(PmsAllergyConstants.ACTIVE_STATUS);
//					AllergyEntity savedEntity = allergyrepo.save(entity);
//					return converter.toDto(savedEntity);
//				}
//		
//		}
//		return dto;
//	}
	@Override
	public AllergyDto saveAllergy(AllergyDto dto) throws CustomException {
		AllergyEntity entity = converter.toEntity(dto);
		Optional<AllergyEntity> optional = repository.findByAllergyCodeAndActiveStatus(dto.getAllergyCode(),
					PmsAllergyConstants.ACTIVE);
		if(optional.isPresent()) {
			throw new CustomException(HttpStatus.CONFLICT, PmsAllergyMsgConstants.ALLERGY_CODE_ALREADY_EXISTS);
		}
		entity.setActiveStatus(PmsAllergyConstants.ACTIVE);
		entity.setCreatedDate(new Date());
		AllergyEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}

	


//	@Override
//	public Optional<AllergyEntity> getAllergybyId(Long id) {
//		System.out.println(allergyrepo.findById(id));
//		return allergyrepo.findById(id);
//	}

//	@Override
//	public AllergyEntity getbyAllergyCode(String allergyCode) {
//		return allergyrepo.findByAllergyCode(allergyCode);
//	}
	
	@Override
	public AllergyDto updateAllergy(AllergyDto dto) throws CustomException {
		AllergyEntity entity = converter.toEntity(dto);
		entity.setUpdatedDate(new Date());
		AllergyEntity updatedEntity = repository.save(entity);
		return converter.toDto(updatedEntity);
	}

	@Override
	public AllergyDto deleteAllergy(Long id) throws CustomException {
		Optional<AllergyEntity> optional = repository.findByAllergyIdAndActiveStatus(id, PmsAllergyConstants.ACTIVE);
		if (optional.isPresent()) {
			AllergyEntity entity = optional.get();
			entity.setActiveStatus(PmsAllergyConstants.DEACTIVE);
			AllergyEntity updatedEntity = repository.save(entity);
			return converter.toDto(updatedEntity);
		} else {
			throw new CustomException(HttpStatus.NOT_FOUND, PmsAllergyMsgConstants.ALLERGY_DOES_NOT_EXISTS);
		}
	}


}
