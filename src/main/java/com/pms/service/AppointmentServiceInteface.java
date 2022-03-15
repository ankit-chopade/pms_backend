package com.pms.service;

import java.util.List;

import com.pms.dto.NurseAppointmentDto;
import com.pms.dto.PatientAppointmentDto;
import com.pms.dto.PhysicianAppointmentDto;

public interface AppointmentServiceInteface {

	

	public List<NurseAppointmentDto> getAppointmentsByDate(String customDate);

	Long deleteAppointment(Long id);

	public List<PatientAppointmentDto> getAppointmentsByDateAndPatientId(String customDate , Long patientId);

	List<PhysicianAppointmentDto> getAppointmentsByDateAndPhysiciantId(String customDate, Long patientId);


//	List<PatientAppointmentDto> getAppointmentsByDateToNurse(String date);

}
