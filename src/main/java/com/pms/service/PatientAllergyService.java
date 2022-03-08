package com.pms.service;

import com.pms.entity.AllergyEntity;
import com.pms.entity.PatientAllergyEntity;

public interface PatientAllergyService {
        
	public void saveAllergyMap(PatientAllergyEntity entity);
	public boolean deleteAllergyMap(Integer allergyId);
	public AllergyEntity deletePatientAllergy(Integer allegyId, Integer patientId );
}
