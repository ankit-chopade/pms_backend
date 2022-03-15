package com.pms.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyDto {
	
	private Long allergyId;

	private String allergyCode;

	private String allergyName;
	private String allergyType;
	private String allergyDescription;
	private String allergyClinicalInfo;
	private String createdDate;

}
