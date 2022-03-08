package com.pms.dto;

import java.util.List;

import com.pms.entity.EmergencyContactEntity;
import com.pms.entity.PatientAllergyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicDetailDto {
	
	private Integer demographicDetailId;
			
	
	private String gender;
		
	private String age;
		
	private String race;
		
	private String ethnicity ;
	
	
	private String languagesKnown ;
		
	
	private String homeAddress;
	
	
	private Integer userId;
	
	
	private int active;
		
	private String has_Allergy;
	
	private EmergencyContactEntity emergencyContactEntity;
	
	private List<PatientAllergyEntity> patientAllergy;
}
