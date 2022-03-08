package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allergy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "allergy_id")
	private Integer allergyId;

	@Column(name = "allergy_code")
	private String allergyCode;

	@Column(name = "allergy_name")
	private String allergyName;

	@Column(name = "allergy_type")
	private String allergyType;

	@Column(name = "allergy_description")
	private String allergyDescription;

	@Column(name = "allergy_clinicalinfo")
	private String allergyClinicalInfo;

	

	
}