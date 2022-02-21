package com.pms.dto;

public class MedicationDto {
		
	private Long medicationId;

	private String drugId;

	private String drugName;
	
	private String drugManufacturerName;
	
	private String drugGenericName;
	
	private String drugForm;
	
	private String drugStrength;

	private Long appointmentId;

	private String createdDate;
	
	private Long patientMedicationId;
	
	private String medicationDetails; 

	public MedicationDto() {
		super();
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

	
	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getPatientMedicationId() {
		return patientMedicationId;
	}

	public void setPatientMedicationId(Long patientMedicationId) {
		this.patientMedicationId = patientMedicationId;
	}

	public String getMedicationDetails() {
		return medicationDetails;
	}

	public void setMedicationDetails(String medicationDetails) {
		this.medicationDetails = medicationDetails;
	}

	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}

	public MedicationDto(Long medicationId, String drugId, String drugName, String drugManufacturerName,
			String drugGenericName, String drugForm, String drugStrength, Long appointmentId, String createdDate,
			Long patientMedicationId, String medicationDetails) {
		super();
		this.medicationId = medicationId;
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugManufacturerName = drugManufacturerName;
		this.drugGenericName = drugGenericName;
		this.drugForm = drugForm;
		this.drugStrength = drugStrength;
		this.appointmentId = appointmentId;
		this.createdDate = createdDate;
		this.patientMedicationId = patientMedicationId;
		this.medicationDetails = medicationDetails;
	}

	
	
	


}
