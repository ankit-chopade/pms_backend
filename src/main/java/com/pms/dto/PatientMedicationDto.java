package com.pms.dto;

public class PatientMedicationDto {

	private Long medicationId;

	private Long appointmentId;

	private String drugManufacturerName;

	private String drugForm;

	private String drugStrength;

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
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

}