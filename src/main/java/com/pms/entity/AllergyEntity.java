package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allergy")

public class AllergyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allergy_id")
	private Integer allergyId;

	@Column(name = "allergy_code")
	private String allergyCode;

	@Column(name = "allergy_name")
	private String allergyName;

	@Column(name = "allergy_type")
	private String allergyType;

	@Column(name = "allergy_description")
	private String allergyDescription;

	@Column(name = "allergy_clinicalinfo")
	private String allergyClinicalInfo;

	public Integer getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyCode() {
		return allergyCode;
	}

	public void setAllergyCode(String allergyCode) {
		this.allergyCode = allergyCode;
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergyDescription() {
		return allergyDescription;
	}

	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}

	public String getAllergyClinicalInfo() {
		return allergyClinicalInfo;
	}

	public void setAllergyClinicalInfo(String allergyClinicalInfo) {
		this.allergyClinicalInfo = allergyClinicalInfo;
	}

	public AllergyEntity(Integer allergyId, String allergyCode, String allergyName, String allergyType,
			String allergyDescription, String allergyClinicalInfo) {
		super();
		this.allergyId = allergyId;
		this.allergyCode = allergyCode;
		this.allergyName = allergyName;
		this.allergyType = allergyType;
		this.allergyDescription = allergyDescription;
		this.allergyClinicalInfo = allergyClinicalInfo;
	}

	public AllergyEntity() {
		super();
	}

	
}