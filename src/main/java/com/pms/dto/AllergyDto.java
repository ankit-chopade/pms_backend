package com.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyDto {
	
	private Integer allergyId;

	private String allergyCode;

	private String allergyName;
	private String allergyType;
	private String allergyDescription;
	private String allergyClinicalInfo;
	private String createdDate;
	
	
	
}
