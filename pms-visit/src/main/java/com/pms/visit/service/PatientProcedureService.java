package com.pms.visit.service;

import java.util.List;

import com.pms.visit.dto.PatientProcedureDto;
import com.pms.visit.dto.PatientProcedureViewDto;

public interface PatientProcedureService {

	public List<PatientProcedureViewDto> getDetailByAppointmentId(Long appointmentId);

	public PatientProcedureDto savePatientProcedure(PatientProcedureDto dto);

	public void deleteById(Long patientProcedureId);

}
