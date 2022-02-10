package com.pms.service;

import com.pms.dto.VitalSignDto;


public interface VitalSignService {

	public VitalSignDto getDetailByAppointmentId(Long appointmentId);
	
	public VitalSignDto saveVitalSigns(VitalSignDto dto);
}
