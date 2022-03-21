package com.pms.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAllergyDto {
	
   private Long patientAllergyId;	
	
	private Integer allergyId;
	
	private Integer allergyIsFatal;
}
