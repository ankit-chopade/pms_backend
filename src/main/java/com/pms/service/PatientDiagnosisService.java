package com.pms.service;

import java.util.List;

import com.pms.dto.DiagnosisDto;
import com.pms.dto.PatientDiagnosisDto;

public interface PatientDiagnosisService {

	public List<DiagnosisDto> getDetailByAppointmentId(Long appointmentId);
	
	public PatientDiagnosisDto savePatientDiagnosis(PatientDiagnosisDto dto);

}
