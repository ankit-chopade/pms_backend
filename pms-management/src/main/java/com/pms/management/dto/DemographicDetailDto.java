package com.pms.management.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicDetailDto {
	
	private Long demographicDetailId;
			
	
	private String gender;
		
	private String age;
		
	private String race;
		
	private String ethnicity ;
	
	
	private String languagesKnown ;
		
	
	private String homeAddress;
	
	
	private Long userId;
	
	
	private int active;
		
	private String hasAllergy;
	
	private EmergencyContactDto emergencyContactEntity;
	
	private List<PatientAllergyDto> patientAllergy;
}
