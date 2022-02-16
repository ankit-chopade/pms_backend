package com.pms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edithistory")
public class EditHistoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long historyId;
	
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name = "end_time")
    private Date endTime;
	
	@Column(name = "start_time")
    private Date startTime;
	
	@Column(name = "patient_id")
    private Long patientId;
	
	@Column(name = "physician_id")
    private Long physicianId;
	
	@Column(name = "edited_by")	
    private Long editedBy;
	
	@Column(name = "reason")	
    private String reason;
	
	@Column(name = "description")	
    private String description;	
	
	@Column(name = "subject")	
    private String subject;
	
	@Column(name = "edit_time")	
    private Date editTime;
	
	
	public Long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(Long physicianId) {
		this.physicianId = physicianId;
	}
	public Long getEditedBy() {
		return editedBy;
	}
	public void setEditedBy(Long editedBy) {
		this.editedBy = editedBy;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
    
    
    
}
