package com.pms.service;

import com.pms.entity.PatientBasicDetail;

public interface PatientBasicDetailService {
	
	public PatientBasicDetail save(PatientBasicDetail patientEntity);
	public PatientBasicDetail getpatientbyId(Integer userid);
	

}
