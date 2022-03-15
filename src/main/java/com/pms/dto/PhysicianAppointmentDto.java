package com.pms.dto;

public class PhysicianAppointmentDto {

private Long appointmentId;
	
	private String subject;
	
	private String description;
	
	private String startTime;
	
	private Long patientId;
	
	private String patientName;

	public PhysicianAppointmentDto() {
	}

	public PhysicianAppointmentDto(Long appointmentId, String subject, String description, String startTime,
			Long patientId, String patientName) {
		super();
		this.appointmentId = appointmentId;
		this.subject = subject;
		this.description = description;
		this.startTime = startTime;
		this.patientId = patientId;
		this.patientName = patientName;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	
}
