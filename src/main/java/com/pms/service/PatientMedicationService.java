package com.pms.service;

import java.util.List;

import com.pms.dto.MedicationDto;
import com.pms.dto.PatientMedicationDto;

public interface PatientMedicationService {

	public List<MedicationDto> getDetailByAppointmentId(Long appointmentId);

	public PatientMedicationDto savePatientMedication(PatientMedicationDto dto);
	
	public void deleteById(Long patientMedicationId);
}
