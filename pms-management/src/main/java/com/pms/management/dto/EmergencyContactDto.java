package com.pms.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDto {
	
	private Long emergencyContactId;
	
	private String firstName;
	
	private String lastName;

	private String email;

	private String homeAddress;

	private Long contactNumber;

	private byte active;

	private String patientRelationship;

	 private String accessPatientPortal;
	
	
}
