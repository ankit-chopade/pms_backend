package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emergencyContact")
@Data
public class EmergencyContactEntity  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emergencyContact_id")
	private Integer emergencyContactId;
	
	
	@Column(name="fristName")
	private String fristName;
	
	@Column(name="lastName")
	private String lastName;
		
	@Column(name="email")
	private String email;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="contact_number")
	private Long contactNumber;
	
	@Column(name="isActive")
	private byte active;
	
	@Column(name="patient_relationship")
	private String patientRelationship;
	
	@Column(name="access_patient_portal")
	 private String accessPatientPortal;
	
	
	
	
	

	public EmergencyContactEntity(Integer emergencyContactId, String fristName, String lastName, String email,
			String homeAddress, Long contactNumber, byte active, String patientRelationship,
			String accessPatientPortal) {
		super();
		this.emergencyContactId = emergencyContactId;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.homeAddress = homeAddress;
		this.contactNumber = contactNumber;
		this.active = active;
		this.patientRelationship = patientRelationship;
		this.accessPatientPortal = accessPatientPortal;
	}






	public EmergencyContactEntity() {
		super();
	}

	
}
