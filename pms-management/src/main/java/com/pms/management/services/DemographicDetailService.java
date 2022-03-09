package com.pms.management.services;

import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.entites.DemographicDetailEntity;

public interface DemographicDetailService {
	
	public DemographicDetailDto save(DemographicDetailDto entity);
	public DemographicDetailDto getpatientbyId(Long userid);
	

}
