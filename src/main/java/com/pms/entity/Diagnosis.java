package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

	@Id
	@Column(name = "Diagnosis_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diagnosisId;
	
	@Column(name = "Diagnosis_Code")
	private String diagnosisCode;
	
	@Column(name = "Diagnosis_Description")
	private String diagnosisDescription;
	
	@Column(name = "Diagnosis_Is_Depricated")
	private Boolean diagnosisIsDepricated;
	
	@ManyToOne
	@JoinColumn(name = "FK_PatientVisitDetails", nullable = false)
	private PatientVisitDetails patientVisitDetails;

	public Diagnosis(Integer diagnosisId, String diagnosisCode, String diagnosisDescription,
			Boolean diagnosisIsDepricated, PatientVisitDetails patientVisitDetails) {
		super();
		this.diagnosisId = diagnosisId;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisDescription = diagnosisDescription;
		this.diagnosisIsDepricated = diagnosisIsDepricated;
		this.patientVisitDetails = patientVisitDetails;
	}

	public Diagnosis() {
		super();
	}

	public Integer getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}

	public Boolean getDiagnosisIsDepricated() {
		return diagnosisIsDepricated;
	}

	public void setDiagnosisIsDepricated(Boolean diagnosisIsDepricated) {
		this.diagnosisIsDepricated = diagnosisIsDepricated;
	}

	public PatientVisitDetails getPatientVisitDetails() {
		return patientVisitDetails;
	}

	public void setPatientVisitDetails(PatientVisitDetails patientVisitDetails) {
		this.patientVisitDetails = patientVisitDetails;
	}

	@Override
	public String toString() {
		return "Diagnosis [diagnosisId=" + diagnosisId + ", diagnosisCode=" + diagnosisCode + ", diagnosisDescription="
				+ diagnosisDescription + ", diagnosisIsDepricated=" + diagnosisIsDepricated + ", patientVisitDetails="
				+ patientVisitDetails + "]";
	}
}
