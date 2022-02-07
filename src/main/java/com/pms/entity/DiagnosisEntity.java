package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	
	public DiagnosisEntity() {
		super();
	}
	

	public DiagnosisEntity(Long diagnosisId, String diagnosisCode, String diagnosisDescription,
			Integer diagnosisIsDepricated) {
		super();
		this.diagnosisId = diagnosisId;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisDescription = diagnosisDescription;
		this.diagnosisIsDepricated = diagnosisIsDepricated;
	}


	public Long getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}

	public Integer getDiagnosisIsDepricated() {
		return diagnosisIsDepricated;
	}

	public void setDiagnosisIsDepricated(Integer diagnosisIsDepricated) {
		this.diagnosisIsDepricated = diagnosisIsDepricated;
	}


	@Override
	public String toString() {
		return "DiagnosisEntity [diagnosisId=" + diagnosisId + ", diagnosisCode=" + diagnosisCode
				+ ", diagnosisDescription=" + diagnosisDescription + ", diagnosisIsDepricated=" + diagnosisIsDepricated
				+ "]";
	}

	
}
