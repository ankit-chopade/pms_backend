package com.pms.management.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.AllergyConverter;
import com.pms.management.dto.AllergyDto;
import com.pms.management.entites.AllergyEntity;
import com.pms.management.repository.AllergyRepo;


@Service
public class AllergyServiceImpl implements AllergyService{
	@Autowired
	private AllergyRepo allergyrepo;
	@Autowired
	private AllergyConverter converter;
	
	public AllergyDto save(AllergyDto dto) {
			AllergyEntity entity = converter.toEntity(dto);
			  entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
				entity.setCreatedBy(1l);
				entity.setCreatedDate(new Date());
				AllergyEntity savedEntity = allergyrepo.save(entity);
				return converter.toDto(savedEntity);
			
		
	}

	
	public List<AllergyDto> getAllergyDetails() {
		List<AllergyEntity> allergyList = allergyrepo.findByActiveStatus(ManagementConstants.ACTIVE_STATUS);
		return converter.toDto(allergyList);
	}


	@Override
	public Optional<AllergyDto> getAllergybyId(Long id) {
		Optional<AllergyEntity> optional = allergyrepo.findById(id);
		AllergyEntity entity= null;
		   if(optional.isPresent()){
			    entity =   optional.get();
			   converter.toDto(entity);
		   }
		 return null;
	}

	@Override
	public AllergyDto getbyAllergyCode(String allergyCode) {
		
		AllergyEntity savedEntity= allergyrepo.findByAllergyCode(allergyCode);
		return converter.toDto(savedEntity);
	}


	@Override

	public List<AllergyDto> getByAllergyIdIn(List<Long> id) {
		List<AllergyEntity> findAllById = allergyrepo.findByAllergyIdIn(id);
		return converter.toDto(findAllById);
	}


}
