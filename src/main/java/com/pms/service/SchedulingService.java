package com.pms.service;

import java.util.List;


import com.pms.common.exception.CustomException;
import com.pms.dto.EditHistoryDto;
import com.pms.entity.EditHistoryEntity;
import com.pms.entity.PatientAppointmentEntity;
import com.pms.entity.UserEntity;

public interface SchedulingService {
	public List<UserEntity> getPhysician();
	public PatientAppointmentEntity savePatientAppointment(PatientAppointmentEntity patientAppointment) throws CustomException;
	public List<PatientAppointmentEntity> getPhysicianAppintments(Long Id) throws CustomException;
	public PatientAppointmentEntity editPatientAppointment(PatientAppointmentEntity patientAppointment) throws CustomException;
	public Long deletePhysicianAppointment(Long Id) throws CustomException;
	public EditHistoryEntity saveEditHistory(EditHistoryEntity editHistoryEntity) throws CustomException;
	public List<EditHistoryDto> getEditHistory(Long Id) throws CustomException;
	public List<UserEntity> getPatient();
	public List<PatientAppointmentEntity> getPatientAppintments(Long Id) throws CustomException;



}
