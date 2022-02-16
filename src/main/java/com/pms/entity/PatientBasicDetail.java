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
@Table(name="patient_basic_detail")
@Data
public class PatientBasicDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_basic_detail_id")
	private Integer patientBasicDetailId;
	
	
	
	@Column(name="patient_gender")
	private String patientGender;
	
	@Column(name="patient_age")
	private String patientAge;
	
	@Column(name="patient_race")
	private String patientRace;
	
	@Column(name="patient_ethnicity")
	private String patientEthnicity ;
	
	
	@Column(name="languagesKnown")
	private String languagesKnown ;
	
	
	@Column(name="home_address ")
	private String homeAddress;
	
	
	@Column(name="user_id")
	private Integer userId;
	
	
	@Column(name="isActive")
	private int active;
	
	@Column(name="patient_knowAllergy")
	private String patientKnowAllergy;
	
	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="emergency_id")
	private EmergencyContactEntity EmergencyContactEntity;

//	 @OneToMany(targetEntity=AllergyDetailsEntity.class, cascade = CascadeType.ALL)
//	 private List<AllergyDetailsEntity> allergyDetailsEntity;
	
	
	@OneToMany(targetEntity=AllergyMapEntity.class, cascade = CascadeType.ALL)
	 @JoinColumn(name="allergyMap")
	private List<AllergyMapEntity> allergyMap;

	 

	public PatientBasicDetail() {
		super();
	}



	public Integer getPatientBasicDetailId() {
		return patientBasicDetailId;
	}



	public void setPatientBasicDetailId(Integer patientBasicDetailId) {
		this.patientBasicDetailId = patientBasicDetailId;
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
		return languagesKnown;
	}



	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
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



	public String getPatientKnowAllergy() {
		return patientKnowAllergy;
	}



	public void setPatientKnowAllergy(String patientKnowAllergy) {
		this.patientKnowAllergy = patientKnowAllergy;
	}



	public EmergencyContactEntity getEmergencyContactEntity() {
		return EmergencyContactEntity;
	}



	public void setEmergencyContactEntity(EmergencyContactEntity emergencyContactEntity) {
		EmergencyContactEntity = emergencyContactEntity;
	}



	public List<AllergyMapEntity> getAllergyMap() {
		return allergyMap;
	}



	public void setAllergyMap(List<AllergyMapEntity> allergyMap) {
		this.allergyMap = allergyMap;
	}



	public PatientBasicDetail(Integer patientBasicDetailId, String patientGender, String patientAge, String patientRace,
			String patientEthnicity, String languagesKnown, String homeAddress, Integer userId, int active,
			String patientKnowAllergy, com.pms.entity.EmergencyContactEntity emergencyContactEntity,
			List<AllergyMapEntity> allergyMap) {
		super();
		this.patientBasicDetailId = patientBasicDetailId;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientRace = patientRace;
		this.patientEthnicity = patientEthnicity;
		this.languagesKnown = languagesKnown;
		this.homeAddress = homeAddress;
		this.userId = userId;
		this.active = active;
		this.patientKnowAllergy = patientKnowAllergy;
		EmergencyContactEntity = emergencyContactEntity;
		this.allergyMap = allergyMap;
	}

}	  
	  
	  
	  
