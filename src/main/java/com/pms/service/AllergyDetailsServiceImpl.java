package com.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.common.util.PmsConstant;
import com.pms.converter.AllergyConverter;
import com.pms.converter.DiagnosisConverter;
import com.pms.dto.AllergyDto;
import com.pms.entity.AllergyEntity;
import com.pms.entity.DiagnosisEntity;
import com.pms.repository.AllergyDetailsRepo;
@Service
public class AllergyDetailsServiceImpl implements AllergyDetailsService{
	@Autowired
	AllergyDetailsRepo allergyrepo;
	@Autowired
	private AllergyConverter converter;
	
	public AllergyDto save(AllergyDto dto) {
		//	return allergyrepo.save(allergyEntity);
			AllergyEntity entity = converter.toEntity(dto);
	//	for(int i=0;i<1000;i++)
	//	{
			if(entity.getAllergyId()==null)
			{
			  entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
				entity.setCreatedBy(1);
				entity.setCreatedDate(new Date());
				AllergyEntity savedEntity = allergyrepo.save(entity);
				return converter.toDto(savedEntity);
			}
			else {
				Optional<AllergyEntity> optional= allergyrepo.findById(entity.getAllergyId());
				if(optional.isPresent()) {
					entity.setAllergyId(optional.get().getAllergyId());
					entity.setUpdatedDate(new Date());
					entity.setActiveStatus(PmsConstant.ACTIVE_STATUS);
					AllergyEntity savedEntity = allergyrepo.save(entity);
					return converter.toDto(savedEntity);
				}
		//	}
			
		}
		return dto;
	}

	public AllergyEntity getAllergyType(String type) {
		
		return allergyrepo.findByallergyType(type);
	}

	public AllergyEntity getAllergyName(String name) {
		
		return allergyrepo.findByallergyName(name);
	}
	
	public List<AllergyEntity> getAllergyDetails() {
		System.out.println(allergyrepo.findAll());
		return allergyrepo.findAll();
	}


	@Override
	public Optional<AllergyEntity> getAllergybyId(Integer id) {
		System.out.println(allergyrepo.findById(id));
		return allergyrepo.findById(id);
	}

	@Override
	public AllergyEntity getbyAllergyCode(String allergyCode) {
		
		return allergyrepo.findByAllergyCode(allergyCode);
	}

	@Override
	public void deleteallergy(Integer allergyId) {
		allergyrepo.deleteById(allergyId);
	}


}
