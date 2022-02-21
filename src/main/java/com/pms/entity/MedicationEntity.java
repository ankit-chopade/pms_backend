package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medications")
public class MedicationEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Medication_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicationId;

	@Column(name = "Drug_Id")
	private String drugId;

	@Column(name = "Drug_Name")
	private String drugName;

	@Column(name = "Drug_Manufacturer_Name")
	private String drugManufacturerName;

	@Column(name = "Drug_Generic_Name")
	private String drugGenericName;

	@Column(name = "Drug_Form")
	private String drugForm;

	@Column(name = "Drug_Strength")
	private String drugStrength;

	public MedicationEntity() {
		super();
	}
	
	public MedicationEntity(Long medicationId, String drugId, String drugName, String drugManufacturerName,
			String drugGenericName, String drugForm, String drugStrength) {
		super();
		this.medicationId = medicationId;
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugManufacturerName = drugManufacturerName;
		this.drugGenericName = drugGenericName;
		this.drugForm = drugForm;
		this.drugStrength = drugStrength;
	}


	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
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
	

	public String getDrugManufacturerName() {
		return drugManufacturerName;
	}

	public void setDrugManufacturerName(String drugManufacturerName) {
		this.drugManufacturerName = drugManufacturerName;
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

	@Override
	public String toString() {
		return "MedicationEntity [medicationId=" + medicationId + ", drugId=" + drugId + ", drugName=" + drugName
				+ ", drugManufacturerName=" + drugManufacturerName + ", drugGenericName=" + drugGenericName
				+ ", drugForm=" + drugForm + ", drugStrength=" + drugStrength + "]";
	}
	
	

}
