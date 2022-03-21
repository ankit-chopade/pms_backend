package com.pms.management.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.management.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emergencyContact")

public class EmergencyContactEntity extends BaseEntity  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emergencyContact_id")
	private Long emergencyContactId;
	
	
	@Column(name="firstName")
	private String firstName;
	
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
	
	

}
