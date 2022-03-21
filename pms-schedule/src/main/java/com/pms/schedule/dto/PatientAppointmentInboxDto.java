package com.pms.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAppointmentInboxDto {

	private Long appointmentId;
	
	private String subject;
	
	private String description;
	
	private String startTime;
	
	private Long patientId;
	
	private String physicianName;
	
}
