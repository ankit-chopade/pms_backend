package com.pms.schedule.service;

import java.util.List;

import com.pms.schedule.dto.EditHistoryDto;
import com.pms.schedule.dto.EditHistorySaveDto;
import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.entity.UserEntity;
import com.pms.schedule.utils.CustomException;


public interface ScheduleService {
	public List<UserEntity> getPhysician();
	public PatientAppointmentDto savePatientAppointment(PatientAppointmentDto patientAppointment) throws CustomException;
	public List<PatientAppointmentDto> getPhysicianAppintments(Long id) throws CustomException;
	public PatientAppointmentDto editPatientAppointment(PatientAppointmentDto patientAppointment) throws CustomException;
	public Long deletePhysicianAppointment(Long id) throws CustomException;
	public EditHistorySaveDto saveEditHistory(EditHistorySaveDto editHistory) throws CustomException;
	public List<EditHistoryDto> getEditHistory(Long id) throws CustomException;
	public List<UserEntity> getPatient();
	public List<PatientAppointmentDto> getPatientAppintments(Long id) throws CustomException;



}
