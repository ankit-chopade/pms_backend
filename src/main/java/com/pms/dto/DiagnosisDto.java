package com.pms.dto;

public class DiagnosisDto {

	private Long diagnosisId;

	private String diagnosisCode;

	private String diagnosisDescription;

	private Integer diagnosisIsDepricated;

	public DiagnosisDto() {
		super();
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

}
