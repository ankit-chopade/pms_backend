package com.pms.management.entites;

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
@Table(name="demographic_detail")

public class DemographicDetailEntity extends BaseEntity   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="demographic_detail_id")
	private Long demographicDetailId;
			
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
	private Long userId;
	
	
	@Column(name="isActive")
	private int active;
	
	@Column(name="has_allergy")
	private String hasAllergy;
	
	@Column(name="contact_number")
	private String contactNo;

	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="emergency_id")
	private EmergencyContactEntity emergencyContactEntity;

	
	@OneToMany(targetEntity=PatientAllergyEntity.class, cascade = CascadeType.ALL)
	 @JoinColumn(name="demographicDetailId")
	private List<PatientAllergyEntity> patientAllergy;


}	  
	  
	  
	  
