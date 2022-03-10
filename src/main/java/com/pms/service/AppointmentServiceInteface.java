package com.pms.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pms.dto.PatientAppointmentDto;
import com.pms.entity.PatientAppointmentEntity;

public interface AppointmentServiceInteface {

	List<PatientAppointmentDto> getAppointmentToPhysician(Long physicianId, LocalDate startDate, LocalDate endDate);

	List<PatientAppointmentDto> getAppointmentToPatient(Long patientId, LocalDate startDate, LocalDate endDate);

	PatientAppointmentDto getAppointmentById(Long id);
	
	public List<PatientAppointmentDto> getAppointmentsByDate( String customDate);

//	List<PatientAppointmentDto> getAppointmentsByDateToNurse(String date);


}
