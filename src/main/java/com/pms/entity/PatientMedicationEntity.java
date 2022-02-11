package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "Patient_Id")
	private Long patientId;

	@Column(name = "Appointment_Id")
	private Long appointmentId;

	@Column(name = "Drug_Manufacturer_Name")
	private String drugManufacturerName;

	@Column(name = "Drug_Form")
	private String drugForm;

	@Column(name = "Drug_Strength")
	private String drugStrength;
	
	public Long getPatientMedicationId() {
		return patientMedicationId;
	}

	public void setPatientMedicationId(Long patientMedicationId) {
		this.patientMedicationId = patientMedicationId;
	}

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
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
	public PatientMedicationEntity() {
		super();
	}

	public PatientMedicationEntity(Long patientMedicationId, Long medicationId, Long patientId, Long appointmentId,
			String drugManufacturerName, String drugForm, String drugStrength) {
		super();
		this.patientMedicationId = patientMedicationId;
		this.medicationId = medicationId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.drugManufacturerName = drugManufacturerName;
		this.drugForm = drugForm;
		this.drugStrength = drugStrength;
	}

	
}
