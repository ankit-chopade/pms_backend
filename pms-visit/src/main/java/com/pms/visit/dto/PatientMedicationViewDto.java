package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientMedicationViewDto {
		
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

}
