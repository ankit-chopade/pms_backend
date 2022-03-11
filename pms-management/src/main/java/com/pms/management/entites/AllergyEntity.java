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

@Entity
@Table(name = "allergy")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "allergy_id")
	private Long allergyId;

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