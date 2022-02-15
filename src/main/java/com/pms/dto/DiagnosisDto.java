package com.pms.dto;

public class DiagnosisDto {

	private Long diagnosisId;

	private String diagnosisCode;

	private String diagnosisDescription;

	private Integer diagnosisIsDepricated;

	private Long appointmentId;

	private String createdDate;
	
	private Long patientDiagnosisId;


	public DiagnosisDto() {
		super();
	}

	

	public DiagnosisDto(Long diagnosisId, String diagnosisCode, String diagnosisDescription,
			Integer diagnosisIsDepricated, Long appointmentId, String createdDate, Long patientDiagnosisId) {
		super();
		this.diagnosisId = diagnosisId;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisDescription = diagnosisDescription;
		this.diagnosisIsDepricated = diagnosisIsDepricated;
		this.appointmentId = appointmentId;
		this.createdDate = createdDate;
		this.patientDiagnosisId = patientDiagnosisId;
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

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getPatientDiagnosisId() {
		return patientDiagnosisId;
	}

	public void setPatientDiagnosisId(Long patientDiagnosisId) {
		this.patientDiagnosisId = patientDiagnosisId;
	}
	

}
