package com.pms.service;

import com.pms.entity.DemographicDetail;

public interface DemographicDetailService {
	
	public DemographicDetail save(DemographicDetail patientEntity);
	public DemographicDetail getpatientbyId(Integer userid);
	

}
