package com.pms.service;

import com.pms.entity.PatientBasicDetail;

public interface PatientBasicDetailService {
	
	public Boolean save(PatientBasicDetail patientEntity);
	public PatientBasicDetail getpatientbyId(Integer userid);
	

}
