package com.pms.service;

import com.pms.entity.PatientEntity;

public interface PatientService {
	
	public Boolean save(PatientEntity patientEntity);
	public PatientEntity getpatientbyId(Integer userid);
	

}
