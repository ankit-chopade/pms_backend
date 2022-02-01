package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="allergydetails")
@Data

public class AllergyDetailsEntity {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="allergydetails_id")
	private String allergyDetailsId;
	
	
	@Column(name="allergy_name")
	private String allergyName;
	

	@Column(name="allergy_type")
	private String allergyType;
	
	@Column(name="allergy_description")
	private String allergyDescription;
	
	@Column(name="allergy_clinicalinfo")
	private String allergyClinicalInfo;

	public String getAllergyDetailsId() {
		return allergyDetailsId;
	}

	public void setAllergyDetailsId(String allergyDetailsId) {
		this.allergyDetailsId = allergyDetailsId;
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

	@Override
	public String toString() {
		return "AllergyDetailsEntity [allergyDetailsId=" + allergyDetailsId + ", allergyName=" + allergyName
				+ ", allergyType=" + allergyType + ", allergyDescription=" + allergyDescription
				+ ", allergyClinicalInfo=" + allergyClinicalInfo + "]";
	}

	public AllergyDetailsEntity(String allergyDetailsId, String allergyName, String allergyType,
			String allergyDescription, String allergyClinicalInfo) {
		super();
		this.allergyDetailsId = allergyDetailsId;
		this.allergyName = allergyName;
		this.allergyType = allergyType;
		this.allergyDescription = allergyDescription;
		this.allergyClinicalInfo = allergyClinicalInfo;
	}

	public AllergyDetailsEntity() {
		super();
	}
	
	
	
}
