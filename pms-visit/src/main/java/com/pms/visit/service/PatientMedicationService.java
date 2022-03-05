package com.pms.visit.service;

import java.util.List;

import com.pms.visit.dto.PatientMedicationDto;
import com.pms.visit.dto.PatientMedicationViewDto;

public interface PatientMedicationService {

	public List<PatientMedicationViewDto> getDetailByAppointmentId(Long appointmentId);

	public PatientMedicationDto savePatientMedication(PatientMedicationDto dto);
	
	public void deleteById(Long patientMedicationId);
}
