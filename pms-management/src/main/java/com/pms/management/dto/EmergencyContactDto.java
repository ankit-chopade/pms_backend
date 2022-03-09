package com.pms.management.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDto {
	
	private Long emergencyContactId;
	
	private String fristName;
	
	private String lastName;

	private String email;

	private String homeAddress;

	private Long contactNumber;

	private byte active;

	private String patientRelationship;

	 private String accessPatientPortal;
	
	
}
