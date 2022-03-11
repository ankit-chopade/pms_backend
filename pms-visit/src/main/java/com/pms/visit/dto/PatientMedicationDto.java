package com.pms.visit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientMedicationDto {

	private Long medicationId;

	private Long appointmentId;

	private String drugManufacturerName;

	private String drugGenericName;

	private String drugForm;

	private String drugStrength;

	private String medicationDetails;

}
