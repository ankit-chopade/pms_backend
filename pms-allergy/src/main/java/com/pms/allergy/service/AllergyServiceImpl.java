package com.pms.allergy.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.allergy.constants.PmsAllergyConstants;
import com.pms.allergy.converter.AllergyConverter;
import com.pms.allergy.dto.AllergyDto;
import com.pms.allergy.entity.AllergyEntity;
import com.pms.allergy.repository.AllergyRepo;
;
@Service
public class AllergyServiceImpl implements AllergyService{
	@Autowired
	AllergyRepo allergyrepo;
	@Autowired
	private AllergyConverter converter;
	
	public AllergyDto save(AllergyDto dto) {
		//	return allergyrepo.save(allergyEntity);
			AllergyEntity entity = converter.toEntity(dto);
	
			if(entity.getAllergyId()==null)
			{
			  entity.setActiveStatus(PmsAllergyConstants.ACTIVE_STATUS);
				entity.setCreatedBy(1l);
				entity.setCreatedDate(new Date());
				AllergyEntity savedEntity = allergyrepo.save(entity);
				return converter.toDto(savedEntity);
			}
			else {
				Optional<AllergyEntity> optional= allergyrepo.findById(entity.getAllergyId());
				if(optional.isPresent()) {
					entity.setAllergyId(optional.get().getAllergyId());
					entity.setUpdatedDate(new Date());
					entity.setUpdatedBy(1l);
					entity.setActiveStatus(PmsAllergyConstants.ACTIVE_STATUS);
					AllergyEntity savedEntity = allergyrepo.save(entity);
					return converter.toDto(savedEntity);
				}
		
			
		}
		return dto;
	}

	
	public List<AllergyEntity> getAllergyDetails() {
		System.out.println(allergyrepo.findAll());
		return allergyrepo.findAll();
	}


	@Override
	public Optional<AllergyEntity> getAllergybyId(Long id) {
		System.out.println(allergyrepo.findById(id));
		return allergyrepo.findById(id);
	}

	@Override
	public AllergyEntity getbyAllergyCode(String allergyCode) {
		
		return allergyrepo.findByAllergyCode(allergyCode);
	}

	@Override
	public void deleteAllergy(Long allergyId) {
		allergyrepo.deleteById(allergyId);
	}


}
