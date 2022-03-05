package com.pms.visit.service;

import java.util.List;

import com.pms.visit.dto.PatientDiagnosisDto;
import com.pms.visit.dto.PatientDiagnosisViewDto;

public interface PatientDiagnosisService {

	public List<PatientDiagnosisViewDto> getDetailByAppointmentId(Long appointmentId);
	
	public PatientDiagnosisDto savePatientDiagnosis(PatientDiagnosisDto dto);

	public void deleteById(Long patientDiagnosisId);

}
