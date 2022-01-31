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
@Table(name = "Medications")
public class Medications {

	
	@Id
	@Column(name = "Medication_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medicationId;
	
	@Column(name = "Drug_Id")
	private String drugId;
	
	@Column(name = "Drug_Name")
	private String drugName;
	
	@Column(name = "Drug_Generic_Name")
	private String drugGenericName;
	
	@Column(name = "Drug_Form")
	private String drugForm;
	
	@Column(name = "Drug_Strength")
	private String drugStrength;
	
	@ManyToOne
	@JoinColumn(name = "FK_PatientVisitDetails", nullable = false)
	private PatientVisitDetails patientVisitDetails;

	public Medications(Integer medicationId, String drugId, String drugName, String drugGenericName, String drugForm,
			String drugStrength, PatientVisitDetails patientVisitDetails) {
		super();
		this.medicationId = medicationId;
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugGenericName = drugGenericName;
		this.drugForm = drugForm;
		this.drugStrength = drugStrength;
		this.patientVisitDetails = patientVisitDetails;
	}

	public Medications() {
		super();
	}

	public Integer getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugGenericName() {
		return drugGenericName;
	}

	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	public String getDrugForm() {
		return drugForm;
	}

	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}

	public String getDrugStrength() {
		return drugStrength;
	}

	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}

	public PatientVisitDetails getPatientVisitDetails() {
		return patientVisitDetails;
	}

	public void setPatientVisitDetails(PatientVisitDetails patientVisitDetails) {
		this.patientVisitDetails = patientVisitDetails;
	}

	@Override
	public String toString() {
		return "Medications [medicationId=" + medicationId + ", drugId=" + drugId + ", drugName=" + drugName
				+ ", drugGenericName=" + drugGenericName + ", drugForm=" + drugForm + ", drugStrength=" + drugStrength
				+ ", patientVisitDetails=" + patientVisitDetails + "]";
	}
	
}
