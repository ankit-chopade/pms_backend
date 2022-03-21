package com.pms.management.services;

import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.utils.CustomException;


public interface DemographicDetailService {
	
	public DemographicDetailDto save(DemographicDetailDto entity);
	
	public DemographicDetailDto getpatientDetailbyUserId(Long userid) throws CustomException;
	
}
