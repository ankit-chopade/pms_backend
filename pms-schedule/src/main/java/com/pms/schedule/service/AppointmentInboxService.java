package com.pms.schedule.service;

import java.util.List;

import com.pms.schedule.dto.NurseAppointmentInboxDto;
import com.pms.schedule.dto.PatientAppointmentInboxDto;
import com.pms.schedule.dto.PhysicianAppointmentInboxDto;

public interface AppointmentInboxService {

	

	public List<NurseAppointmentInboxDto> getAppointmentsByDate(String customDate);

	public List<PatientAppointmentInboxDto> getAppointmentsByDateAndPatientId(String customDate , Long patientId);

	public List<PhysicianAppointmentInboxDto> getAppointmentsByDateAndPhysiciantId(String customDate, Long patientId);
	public Long deleteAppointment(Long appointmentId);
}
