package com.pms.management.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAllergyDto {
	
   private Long patientAllergyId;	
	
	private Integer allergyId;
}
