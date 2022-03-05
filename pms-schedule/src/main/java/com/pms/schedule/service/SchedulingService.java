package com.pms.schedule.service;

import java.util.List;

import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.utils.CustomException;

public interface SchedulingService {
	// public List<UserEntity> getPhysician();
	public PatientAppointmentEntity savePatientAppointment(PatientAppointmentEntity patientAppointment)
			throws CustomException;

	public List<PatientAppointmentEntity> getPhysicianAppintments(Long Id) throws CustomException;

	public PatientAppointmentEntity editPatientAppointment(PatientAppointmentEntity patientAppointment)
			throws CustomException;

	public Long deletePhysicianAppointment(Long Id) throws CustomException;

	public EditHistoryEntity saveEditHistory(EditHistoryEntity editHistoryEntity) throws CustomException;

//	public List<EditHistoryDto> getEditHistory(Long Id) throws CustomException;

	// public List<UserEntity> getPatient();
	public List<PatientAppointmentEntity> getPatientAppintments(Long Id) throws CustomException;

	public List<Long> getAllAppointmentsByAppointmentId(Long appointmentId);
}
