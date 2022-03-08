package com.pms.entity;

import java.io.Serializable;
import java.util.List;

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

import lombok.Data;

@Entity
@Table(name="demographic_detail")

public class DemographicDetail  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="demographic_detail_id")
	private Integer demographicDetailId;
			
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private String age;
	
	@Column(name="race")
	private String race;
	
	@Column(name="ethnicity")
	private String ethnicity ;
	
	
	@Column(name="languages_Known")
	private String languagesKnown ;
	
	
	@Column(name="home_address ")
	private String homeAddress;
	
	
	@Column(name="user_id")
	private Integer userId;
	
	
	@Column(name="isActive")
	private int active;
	
	@Column(name="has_allergy")
	private String has_Allergy;
	
	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="emergency_id")
	private EmergencyContactEntity emergencyContactEntity;

//	 @OneToMany(targetEntity=AllergyDetailsEntity.class, cascade = CascadeType.ALL)
//	 private List<AllergyDetailsEntity> allergyDetailsEntity;
	
	
	@OneToMany(targetEntity=PatientAllergyEntity.class, cascade = CascadeType.ALL)
	 @JoinColumn(name="demographicDetailId")
	private List<PatientAllergyEntity> patientAllergy;

	public Integer getDemographicDetailId() {
		return demographicDetailId;
	}

	public void setDemographicDetailId(Integer demographicDetailId) {
		this.demographicDetailId = demographicDetailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
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

	public String getHas_Allergy() {
		return has_Allergy;
	}

	public void setHas_Allergy(String has_Allergy) {
		this.has_Allergy = has_Allergy;
	}

	public EmergencyContactEntity getEmergencyContactEntity() {
		return emergencyContactEntity;
	}

	public void setEmergencyContactEntity(EmergencyContactEntity emergencyContactEntity) {
		this.emergencyContactEntity = emergencyContactEntity;
	}

	public List<PatientAllergyEntity> getPatientAllergy() {
		return patientAllergy;
	}

	public void setPatientAllergy(List<PatientAllergyEntity> patientAllergy) {
		this.patientAllergy = patientAllergy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DemographicDetail(Integer demographicDetailId, String gender, String age, String race, String ethnicity,
			String languagesKnown, String homeAddress, Integer userId, int active, String has_Allergy,
			EmergencyContactEntity emergencyContactEntity, List<PatientAllergyEntity> patientAllergy) {
		super();
		this.demographicDetailId = demographicDetailId;
		this.gender = gender;
		this.age = age;
		this.race = race;
		this.ethnicity = ethnicity;
		this.languagesKnown = languagesKnown;
		this.homeAddress = homeAddress;
		this.userId = userId;
		this.active = active;
		this.has_Allergy = has_Allergy;
		this.emergencyContactEntity = emergencyContactEntity;
		this.patientAllergy = patientAllergy;
	}

	@Override
	public String toString() {
		return "DemographicDetail [demographicDetailId=" + demographicDetailId + ", gender=" + gender + ", age=" + age
				+ ", race=" + race + ", ethnicity=" + ethnicity + ", languagesKnown=" + languagesKnown
				+ ", homeAddress=" + homeAddress + ", userId=" + userId + ", active=" + active + ", has_Allergy="
				+ has_Allergy + ", emergencyContactEntity=" + emergencyContactEntity + ", patientAllergy="
				+ patientAllergy + "]";
	}

	public DemographicDetail() {
		super();
	}

	
	
	

}	  
	  
	  
	  
