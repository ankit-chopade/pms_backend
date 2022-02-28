package com.pms.service;

import com.pms.entity.AllergyEntity;
import com.pms.entity.AllergyMapEntity;

public interface AllergyMapService {
        
	public void saveAllergyMap(AllergyMapEntity entity);
	public boolean deleteAllergyMap(Integer allergyId);
	public AllergyEntity deletePatientAllergy(Integer allegyId, Integer patientId );
}
