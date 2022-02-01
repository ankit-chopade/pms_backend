package com.pms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Library;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="patient")
@Data
public class PatientEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private Integer patientId;
	
	@Column(name="patient_title")
	private String patientTitle;
	
	@Column(name="patient_fname")
	private String patientFirstName;
		
	@Column(name="patient_lname")
	private String patientLastName;
	
	@Column(name="patient_dob")
	private Date patientDob;

	
	@Column(name="patient_gender")
	private String patientGender;
	
	@Column(name="patient_age")
	private String patientAge;
	
	@Column(name="patient_race")
	private String patientRace;
	
	@Column(name="patient_ethnicity")
	private String patientEthnicity ;
	
	
	@Column(name="LanguagesKnown")
	private String LanguagesKnown ;
	
	
	@Column(name="patient_email")
	private String patientEmail;
	
	@Column(name="home_address ")
	private String homeAddress;
	
	@Column(name="patient_contact")
	private Long patientContact;
	
	
	
	@Column(name="isActive")
	private int active;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmergencyContactEntity EmergencyContactEntity;

	 @OneToMany(targetEntity=AllergyDetailsEntity.class, cascade = CascadeType.ALL)

	  @JoinColumn(name="allergyDetails_id")
	 private List<AllergyDetailsEntity> allergyDetailsEntity;

	  
	 
	 
	/*@OneToOne(cascade = CascadeType.ALL)
	private EmergencyContactEntity EmergencyContactEntity;

	  
	 @OneToMany(targetEntity=AllergyDetailsEntity.class)  

	  private Set<AllergyDetailsEntity> allergyDetailsEntity;

	 */
	 
	 

	public Integer getPatientId() {
		return patientId;
	}

	public PatientEntity(String patientTitle, String patientFirstName, String patientLastName, Date patientDob,
			 String patientEmail, Long patientContact) {
		super();
		this.patientTitle = patientTitle;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientDob = patientDob;
		this.patientEmail = patientEmail;
		this.patientContact = patientContact;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientTitle() {
		return patientTitle;
	}

	public void setPatientTitle(String patientTitle) {
		this.patientTitle = patientTitle;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	
	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientRace() {
		return patientRace;
	}

	public void setPatientRace(String patientRace) {
		this.patientRace = patientRace;
	}

	public String getPatientEthnicity() {
		return patientEthnicity;
	}

	public void setPatientEthnicity(String patientEthnicity) {
		this.patientEthnicity = patientEthnicity;
	}

	
	public String getLanguagesKnown() {
		return LanguagesKnown;
	}

	public void setLanguagesKnown(String languagesKnown) {
		LanguagesKnown = languagesKnown;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	public EmergencyContactEntity getEmergencyContactEntity() {
		return EmergencyContactEntity;
	}

	public void setEmergencyContactEntity(EmergencyContactEntity emergencyContactEntity) {
		EmergencyContactEntity = emergencyContactEntity;
	}

	public List<AllergyDetailsEntity> getAllergyDetailsEntity() {
		return allergyDetailsEntity;
	}

	public void setAllergyDetailsEntity(List<AllergyDetailsEntity> allergyDetailsEntity) {
		this.allergyDetailsEntity = allergyDetailsEntity;
	}

	

public Date getPatientDob() {
		return patientDob;
	}

	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}

	public Long getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(Long patientContact) {
		this.patientContact = patientContact;
	}

public PatientEntity(Integer patientId, String patientTitle, String patientFirstName, String patientLastName,
			Date patientDob, String patientGender, String patientAge, String patientRace, String patientEthnicity,
			String languagesKnown, String patientEmail, String homeAddress, Long patientContact, int active,
			com.pms.entity.EmergencyContactEntity emergencyContactEntity,
			List<AllergyDetailsEntity> allergyDetailsEntity) {
		super();
		this.patientId = patientId;
		this.patientTitle = patientTitle;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientDob = patientDob;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientRace = patientRace;
		this.patientEthnicity = patientEthnicity;
		LanguagesKnown = languagesKnown;
		this.patientEmail = patientEmail;
		this.homeAddress = homeAddress;
		this.patientContact = patientContact;
		this.active = active;
		EmergencyContactEntity = emergencyContactEntity;
		this.allergyDetailsEntity = allergyDetailsEntity;
	}

public PatientEntity() {
	super();
}

@Override
public String toString() {
	return "PatientEntity [patientId=" + patientId + ", patientTitle=" + patientTitle + ", patientFirstName="
			+ patientFirstName + ", patientLastName=" + patientLastName + ", patientDob=" + patientDob
			+ ", patientGender=" + patientGender + ", patientAge=" + patientAge + ", patientRace=" + patientRace
			+ ", patientEthnicity=" + patientEthnicity + ", LanguagesKnown=" + LanguagesKnown + ", patientEmail="
			+ patientEmail + ", homeAddress=" + homeAddress + ", patientContact=" + patientContact + ", active="
			+ active + ", EmergencyContactEntity=" + EmergencyContactEntity + ", allergyDetailsEntity="
			+ allergyDetailsEntity + "]";
}

 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}	  
	  
	  
	  
