package com.pms.management.services;

import java.util.List;

import com.pms.management.dto.AllergyDto;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.AllergyEntity;


public interface DemographicDetailService {
	
	public DemographicDetailDto save(DemographicDetailDto entity);
	public DemographicDetailDto getpatientbyId(Long userid);
	public List<AllergyEntity> getAllAllergy();
	public AllergyDto save(AllergyDto dto);
}
