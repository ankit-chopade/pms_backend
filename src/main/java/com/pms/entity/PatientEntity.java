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
	
	
	@Column(name="home_address ")
	private String homeAddress;
	
	
	@Column(name="user_id")
	private Integer userId;
	
	
	@Column(name="isActive")
	private int active;
	
	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="emergency_id")
	private EmergencyContactEntity EmergencyContactEntity;

//	 @OneToMany(targetEntity=AllergyDetailsEntity.class, cascade = CascadeType.ALL)
//	 private List<AllergyDetailsEntity> allergyDetailsEntity;
	
	
	@OneToMany(targetEntity=AllergyIdEntity.class, cascade = CascadeType.ALL)
	private List<AllergyIdEntity> allergyDetailsId;

	 
	 
	 
	 
	public PatientEntity(Integer patientId, String patientGender, String patientAge, String patientRace,
			String patientEthnicity, String languagesKnown, String homeAddress, Integer userId, int active,
			com.pms.entity.EmergencyContactEntity emergencyContactEntity, List<AllergyIdEntity> allergyDetailsId) {
		super();
		this.patientId = patientId;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientRace = patientRace;
		this.patientEthnicity = patientEthnicity;
		LanguagesKnown = languagesKnown;
		this.homeAddress = homeAddress;
		this.userId = userId;
		this.active = active;
		EmergencyContactEntity = emergencyContactEntity;
		this.allergyDetailsId = allergyDetailsId;
	}

	public PatientEntity() {
		super();
	}

	
	  public List<AllergyIdEntity> getAllergyDetailsId() { 
		  return allergyDetailsId;
	  }
	  
	  public void setAllergyDetailsId(List<AllergyIdEntity> allergyDetailsId) {
	        this.allergyDetailsId = allergyDetailsId; 
	  }
	 

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public String toString() {
		return "BaseEntity [patientId=" + patientId + ", patientGender=" + patientGender + ", patientAge=" + patientAge
				+ ", patientRace=" + patientRace + ", patientEthnicity=" + patientEthnicity + ", LanguagesKnown="
				+ LanguagesKnown + ", homeAddress=" + homeAddress + ", userId=" + userId + ", active=" + active
				+ ", EmergencyContactEntity=" + EmergencyContactEntity + ", allergyDetailsEntity="
				+ allergyDetailsId
				+ "]";
	}

	  
	 
	 
	/*@OneToOne(cascade = CascadeType.ALL)
	private EmergencyContactEntity EmergencyContactEntity;

	  
	 @OneToMany(targetEntity=AllergyDetailsEntity.class)  

	  private Set<AllergyDetailsEntity> allergyDetailsEntity;

	 */
	 
	 

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}	  
	  
	  
	  
