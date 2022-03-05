package com.pms.medication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicationDto {

	private Long medicationId;

	private String drugId;

	private String drugName;

	private String drugManufacturerName;

	private String drugGenericName;

	private String drugForm;

	private String drugStrength;

}
