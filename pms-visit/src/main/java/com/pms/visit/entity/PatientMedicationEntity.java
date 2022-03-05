package com.pms.visit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.visit.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient_Medications")
public class PatientMedicationEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Patient_Medication_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientMedicationId;

	@Column(name = "Medication_Id")
	private Long medicationId;

	
	@Column(name = "Appointment_Id")
	private Long appointmentId;

	@Column(name = "Drug_Manufacturer_Name")
	private String drugManufacturerName;

	@Column(name = "Drug_Form")
	private String drugForm;

	@Column(name = "Drug_Strength")
	private String drugStrength;

	@Column(name = "Drug_Generic_Name")
	private String drugGenericName;

	@Column(name = "medication_Details")
	private String medicationDetails;

}
