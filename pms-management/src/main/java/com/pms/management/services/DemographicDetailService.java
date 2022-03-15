package com.pms.management.services;

import java.util.List;

import com.pms.management.dto.AllergyDto;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.AllergyEntity;
import com.pms.management.utils.CustomException;


public interface DemographicDetailService {
	
	public DemographicDetailDto save(DemographicDetailDto entity);
	public DemographicDetailDto getpatientbyId(Long userid) throws CustomException;;
	public List<AllergyEntity> getAllAllergy();
	public AllergyDto save(AllergyDto dto);
}
