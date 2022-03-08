package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_allergy")
public class PatientAllergyEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patientAllergy_Id")
	private Integer patientAllergyId;
	
	@Column(name="allergy_id")
	private Integer allergyId;

	public Integer getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(Integer patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	public Integer getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
	}

	public PatientAllergyEntity(Integer patientAllergyId, Integer allergyId) {
		super();
		this.patientAllergyId = patientAllergyId;
		this.allergyId = allergyId;
	}

	public PatientAllergyEntity() {
		super();
	}

	
}
