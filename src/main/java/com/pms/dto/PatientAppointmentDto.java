package com.pms.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;

public class PatientAppointmentDto {

	private Long appointmentId;
	
	private String subject;
	
	private String description;
	
	private String startTime;
	
	private Long patientId;
	
	private String physicianName;
	
	
	//private LocalDate appointmentDate;
	
	public PatientAppointmentDto() {
	}

	

	
	

	public PatientAppointmentDto(Long appointmentId, String subject, String description, String startTime,
			Long patientId, String physicianName) {
		super();
		this.appointmentId = appointmentId;
		this.subject = subject;
		this.description = description;
		this.startTime = startTime;
		this.patientId = patientId;
		this.physicianName = physicianName;
	}






	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	
//	private Long edit_id;
	
	
	
}
