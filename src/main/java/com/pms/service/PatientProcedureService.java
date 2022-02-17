package com.pms.service;

import java.util.List;

import com.pms.dto.PatientProcedureDto;
import com.pms.dto.ProcedureDto;

public interface PatientProcedureService {

	public List<ProcedureDto> getDetailByAppointmentId(Long appointmentId);

	public PatientProcedureDto savePatientProcedure(PatientProcedureDto dto);

	public void deleteById(Long patientProcedureId);

}
