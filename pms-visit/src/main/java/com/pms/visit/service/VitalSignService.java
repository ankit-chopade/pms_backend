package com.pms.visit.service;

import java.util.List;

import com.pms.visit.dto.DashboardVitalDto;
import com.pms.visit.dto.VitalSignDto;

public interface VitalSignService {

	public VitalSignDto getDetailByAppointmentId(Long appointmentId);
	
	public VitalSignDto saveVitalSigns(VitalSignDto dto);

	public List<String> getBloodPressure(Long patientId);

	public List<String> getRespirationRate(Long patientId);

	public DashboardVitalDto getLatestVitalSigns(Long patientId);
}
