package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardVitalDto {

	private Integer height;

	private String respirationRate;
	
	private Integer weight;

	private String bodyTemperature;
	
}
