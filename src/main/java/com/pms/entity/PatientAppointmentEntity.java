package com.pms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientappointment")
public class PatientAppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name = "end_time")
    private Date endTime;
	
	@Column(name = "end_time_zone")
	private String endTimezone;
	
	@Column(name = "appointment_number")
	private Long id;
	
	@Column(name = "is_all_day")
	private Boolean isAllDay;
	
	@Column(name = "recurrence_rule")
	private  String recurrenceRule;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "start_time_zone")
	private String startTimezone;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "is_readonly")
	private Boolean isReadonly;
	
	@Column(name = "is_block")
	private Boolean isBlock;
	
	@Column(name ="description")
	private String description;
	

	@Column(name = "patient_id")
	private Long patientId;
	
	@Column(name = "physician_id")
	private Long physicianId;
	
	

	
	public PatientAppointmentEntity() {}
	public PatientAppointmentEntity(Long appointmentId, Date endTime, String endTimezone, Long id, Boolean isAllDay,
			String recurrenceRule, Date startTime, String startTimezone, String subject, Boolean isReadonly,
			Boolean isBlock, String description, Long patientId, Long physicianId) {
		super();
		this.appointmentId = appointmentId;
		this.endTime = endTime;
		this.endTimezone = endTimezone;
		this.id = id;
		this.isAllDay = isAllDay;
		this.recurrenceRule = recurrenceRule;
		this.startTime = startTime;
		this.startTimezone = startTimezone;
		this.subject = subject;
		this.isReadonly = isReadonly;
		this.isBlock = isBlock;
		this.description = description;
		this.patientId = patientId;
		this.physicianId = physicianId;
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

	public String getEndTimezone() {
		return endTimezone;
	}

	public void setEndTimezone(String endTimezone) {
		this.endTimezone = endTimezone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsAllDay() {
		return isAllDay;
	}

	public void setIsAllDay(Boolean isAllDay) {
		this.isAllDay = isAllDay;
	}

	public String getRecurrenceRule() {
		return recurrenceRule;
	}

	public void setRecurrenceRule(String recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getStartTimezone() {
		return startTimezone;
	}

	public void setStartTimezone(String startTimezone) {
		this.startTimezone = startTimezone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getIsReadonly() {
		return isReadonly;
	}

	public void setIsReadonly(Boolean isReadonly) {
		this.isReadonly = isReadonly;
	}

	public Boolean getIsBlock() {
		return isBlock;
	}

	public void setIsBlock(Boolean isBlock) {
		this.isBlock = isBlock;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	
	

}
