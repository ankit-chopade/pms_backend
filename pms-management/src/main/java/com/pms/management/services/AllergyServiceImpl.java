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
	AllergyRepo allergyrepo;
	@Autowired
	private AllergyConverter converter;
	
	public AllergyDto save(AllergyDto dto) {
		//	return allergyrepo.save(allergyEntity);
			AllergyEntity entity = converter.toEntity(dto);
	
			if(entity.getAllergyId()==null)
			{
			  entity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
				entity.setCreatedBy(1l);
				entity.setCreatedDate(new Date());
				AllergyEntity savedEntity = allergyrepo.save(entity);
				return converter.toDto(savedEntity);
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


}
