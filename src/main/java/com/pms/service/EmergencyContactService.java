package com.pms.service;

import com.pms.entity.EmergencyContactEntity;
import com.pms.entity.PatientBasicDetail;

public interface EmergencyContactService {
	public EmergencyContactEntity save(EmergencyContactEntity emergencyContactEntity);
	public EmergencyContactEntity getEmergencybyId(int emergencyId);
}
