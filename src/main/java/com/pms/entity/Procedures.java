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
@Table(name = "Procedures")
public class Procedures {

	
	@Id
	@Column(name = "Procedure_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer procedureID;
	
	@Column(name = "Procedure_Code")
	private String procedureCode;
	
	@Column(name = "Procedure_Description")
	private String procedureDescription;
	
	@Column(name = "Procedure_Is_Depricated")
	private Boolean procedureIsDepricated;
	
	@ManyToOne
	@JoinColumn(name = "FK_PatientVisitDetails", nullable = false)
	private PatientVisitDetails patientVisitDetails;

	public Procedures(Integer procedureID, String procedureCode, String procedureDescription,
			Boolean procedureIsDepricated, PatientVisitDetails patientVisitDetails) {
		super();
		this.procedureID = procedureID;
		this.procedureCode = procedureCode;
		this.procedureDescription = procedureDescription;
		this.procedureIsDepricated = procedureIsDepricated;
		this.patientVisitDetails = patientVisitDetails;
	}

	public Procedures() {
		super();
	}

	public Integer getProcedureID() {
		return procedureID;
	}

	public void setProcedureID(Integer procedureID) {
		this.procedureID = procedureID;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}

	public String getProcedureDescription() {
		return procedureDescription;
	}

	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}

	public Boolean getProcedureIsDepricated() {
		return procedureIsDepricated;
	}

	public void setProcedureIsDepricated(Boolean procedureIsDepricated) {
		this.procedureIsDepricated = procedureIsDepricated;
	}

	public PatientVisitDetails getPatientVisitDetails() {
		return patientVisitDetails;
	}

	public void setPatientVisitDetails(PatientVisitDetails patientVisitDetails) {
		this.patientVisitDetails = patientVisitDetails;
	}

	@Override
	public String toString() {
		return "Procedures [procedureID=" + procedureID + ", procedureCode=" + procedureCode + ", procedureDescription="
				+ procedureDescription + ", procedureIsDepricated=" + procedureIsDepricated + ", patientVisitDetails="
				+ patientVisitDetails + "]";
	}
	
}
