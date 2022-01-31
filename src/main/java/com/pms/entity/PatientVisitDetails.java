package com.pms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PatientVisitDetails")
public class PatientVisitDetails {

	
	
	@Id
	@Column(name = "Visit_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer visitId;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patientVisitDetails")
	private VitalSigns vitalSigns;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientVisitDetails", fetch = FetchType.LAZY)
	private List<Diagnosis> diagnosisi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientVisitDetails", fetch = FetchType.LAZY)
	private List<Procedures> procedure;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientVisitDetails", fetch = FetchType.LAZY)
	private List<Medications> medications;

	public PatientVisitDetails() {
		super();
	}

	public PatientVisitDetails(Integer visitId, VitalSigns vitalSigns, List<Diagnosis> diagnosisi,
			List<Procedures> procedure, List<Medications> medications) {
		super();
		this.visitId = visitId;
		this.vitalSigns = vitalSigns;
		this.diagnosisi = diagnosisi;
		this.procedure = procedure;
		this.medications = medications;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public VitalSigns getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(VitalSigns vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public List<Diagnosis> getDiagnosisi() {
		return diagnosisi;
	}

	public void setDiagnosisi(List<Diagnosis> diagnosisi) {
		this.diagnosisi = diagnosisi;
	}

	public List<Procedures> getProcedure() {
		return procedure;
	}

	public void setProcedure(List<Procedures> procedure) {
		this.procedure = procedure;
	}

	public List<Medications> getMedications() {
		return medications;
	}

	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	@Override
	public String toString() {
		return "PatientVisitDetails [visitId=" + visitId + ", vitalSigns=" + vitalSigns + ", diagnosisi=" + diagnosisi
				+ ", procedure=" + procedure + ", medications=" + medications + "]";
	}
	
}
