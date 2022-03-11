package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalSignDto {

	private Integer height;

	private Integer weight;

	private String bloodPressure;

	private String bodyTemperature;

	private String respirationRate;

	private Long appointmentId;
	
	private Long vitalId;

}
