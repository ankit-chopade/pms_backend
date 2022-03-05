package com.pms.medication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.medication.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medications")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
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

}
