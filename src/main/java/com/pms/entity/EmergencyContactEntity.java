package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emergencyContact")
@Data
public class EmergencyContactEntity {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emergencyContact_id")
	private Integer emergencyContactId;
	
	
	@Column(name="emergencyContact_name")
	private String EmergencyContactName;
		
	@Column(name="emergencyContact_email")
	private String EmergencyContactEmail;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="emergency_contact")
	private Long emergencyContact;
	
	@Column(name="isActive")
	private byte active;
	
	@Column(name="patientRelationship")
	private String patientRelationship;
	
	
	 
	public Integer getEmergencyContactId() {
		return emergencyContactId;
	}

	public void setEmergencyContactId(Integer emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
	}

	public String getEmergencyContactName() {
		return EmergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		EmergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactEmail() {
		return EmergencyContactEmail;
	}

	public void setEmergencyContactEmail(String emergencyContactEmail) {
		EmergencyContactEmail = emergencyContactEmail;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Long getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(Long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	

	public String getPatientRelationship() {
		return patientRelationship;
	}

	public void setPatientRelationship(String patientRelationship) {
		this.patientRelationship = patientRelationship;
	}

	

	public EmergencyContactEntity(Integer emergencyContactId, String emergencyContactName, String emergencyContactEmail,
			String homeAddress, Long emergencyContact, byte active, String patientRelationship) {
		super();
		this.emergencyContactId = emergencyContactId;
		EmergencyContactName = emergencyContactName;
		EmergencyContactEmail = emergencyContactEmail;
		this.homeAddress = homeAddress;
		this.emergencyContact = emergencyContact;
		this.active = active;
		this.patientRelationship = patientRelationship;
	}

	public EmergencyContactEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EmergencyContactEntity [emergencyContactId=" + emergencyContactId + ", EmergencyContactName="
				+ EmergencyContactName + ", EmergencyContactEmail=" + EmergencyContactEmail + ", homeAddress="
				+ homeAddress + ", emergencyContact=" + emergencyContact + ", active=" + active
				+ ", patientRelationship=" + patientRelationship + "]";
	}
	
	
	
//	 @OneToOne(mappedBy = "emergencyContact")
//    private PatientEntity patientEntity;
	
	
	
}
