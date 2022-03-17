package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientVisitHistoryViewDto {

	private Long appointmentId;
	
	private String subject;

	private String description;

	private String startTime;

	private String endTime;

	private Long patientId;

	private String physicianName;

}
