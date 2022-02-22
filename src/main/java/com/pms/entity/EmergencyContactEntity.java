package com.pms.entity;

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
public class EmergencyContactEntity {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emergencyContact_id")
	private Integer emergencyContactId;
	
	
	@Column(name="emergencyContact_fristName")
	private String emergencyContactFristName;
	
	@Column(name="emergencyContact_lastName")
	private String emergencyContactLastName;
		
	@Column(name="emergencyContact_email")
	private String emergencyContactEmail;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="emergency_contact")
	private Long emergencyContact;
	
	@Column(name="isActive")
	private byte active;
	
	@Column(name="patientRelationship")
	private String patientRelationship;
	
	@Column(name="accessPatient_portal")
	 private String accessPatientPortal;

	public Integer getEmergencyContactId() {
		return emergencyContactId;
	}

	public void setEmergencyContactId(Integer emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
	}

	public String getEmergencyContactFristName() {
		return emergencyContactFristName;
	}

	public void setEmergencyContactFristName(String emergencyContactFristName) {
		this.emergencyContactFristName = emergencyContactFristName;
	}

	public String getEmergencyContactLastName() {
		return emergencyContactLastName;
	}

	public void setEmergencyContactLastName(String emergencyContactLastName) {
		this.emergencyContactLastName = emergencyContactLastName;
	}

	public String getEmergencyContactEmail() {
		return emergencyContactEmail;
	}

	public void setEmergencyContactEmail(String emergencyContactEmail) {
		this.emergencyContactEmail = emergencyContactEmail;
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

	public String getAccessPatientPortal() {
		return accessPatientPortal;
	}

	public void setAccessPatientPortal(String accessPatientPortal) {
		this.accessPatientPortal = accessPatientPortal;
	}

	public EmergencyContactEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EmergencyContactEntity [emergencyContactId=" + emergencyContactId + ", emergencyContactFristName="
				+ emergencyContactFristName + ", emergencyContactLastName=" + emergencyContactLastName
				+ ", emergencyContactEmail=" + emergencyContactEmail + ", homeAddress=" + homeAddress
				+ ", emergencyContact=" + emergencyContact + ", active=" + active + ", patientRelationship="
				+ patientRelationship + ", accessPatientPortal=" + accessPatientPortal + "]";
	}
	 
	

	
	
}
