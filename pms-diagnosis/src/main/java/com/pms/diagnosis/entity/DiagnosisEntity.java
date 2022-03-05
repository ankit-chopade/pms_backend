package com.pms.diagnosis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.diagnosis.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Diagnosis")
public class DiagnosisEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Diagnosis_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long diagnosisId;

	@Column(name = "Diagnosis_Code")
	private String diagnosisCode;

	@Column(name = "Diagnosis_Description")
	private String diagnosisDescription;

	@Column(name = "Diagnosis_IsDepricated")
	private Integer diagnosisIsDepricated;

}
