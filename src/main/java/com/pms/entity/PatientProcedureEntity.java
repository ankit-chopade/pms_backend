package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient_Procedures")
public class PatientProcedureEntity extends BaseEntity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Patient_Procedure_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientProcedureId;

	@Column(name="Procedure_Id")
	private Long procedureId;

	@Column(name = "Patient_Id")
	private Long patientId;
	
	@Column(name = "Appointment_Id")
	private Long appointmentId;
	
	@Column(name = "procedureDetails")
	private String procedureDetails;

	public Long getPatientProcedureId() {
		return patientProcedureId;
	}

	public void setPatientProcedureId(Long patientProcedureId) {
		this.patientProcedureId = patientProcedureId;
	}

	public Long getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	
	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public PatientProcedureEntity() {
		super();
	}

	public PatientProcedureEntity(Long patientProcedureId, Long procedureId, Long patientId, Long appointmentId,
			String procedureDetails) {
		super();
		this.patientProcedureId = patientProcedureId;
		this.procedureId = procedureId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.procedureDetails = procedureDetails;
	}
}
