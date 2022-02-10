package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Diagnosis")
public class PatientDiagnosisEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Patient_Diagnosis_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userDiagnosisId;

	@Column(name="Diagnosis_Id")
	private Long diagnosisId;

	@Column(name = "Patient_Id")
	private Long patientId;
	
	@Column(name = "Appointment_Id")
	private Long appointmentId;

	public Long getUserDiagnosisId() {
		return userDiagnosisId;
	}

	public void setUserDiagnosisId(Long userDiagnosisId) {
		this.userDiagnosisId = userDiagnosisId;
	}

	public Long getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
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
	
	public PatientDiagnosisEntity() {
		super();
	}
	public PatientDiagnosisEntity(Long userDiagnosisId, Long diagnosisId, Long patientId, Long appointmentId) {
		super();
		this.userDiagnosisId = userDiagnosisId;
		this.diagnosisId = diagnosisId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "PatientDiagnosisEntity [userDiagnosisId=" + userDiagnosisId + ", diagnosisId=" + diagnosisId
				+ ", patientId=" + patientId + ", appointmentId=" + appointmentId + "]";
	}
	
		
	


	
}
