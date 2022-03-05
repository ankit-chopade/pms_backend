package com.pms.visit.service;

import com.pms.visit.dto.VitalSignDto;


public interface VitalSignService {

	public VitalSignDto getDetailByAppointmentId(Long appointmentId);
	
	public VitalSignDto saveVitalSigns(VitalSignDto dto);
}
