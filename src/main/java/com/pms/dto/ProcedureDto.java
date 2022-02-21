package com.pms.dto;

public class ProcedureDto {

	private Long procedureId;

	private String procedureCode;

	private String procedureDescription;

	private Integer procedureIsDepricated;
	
	private Long appointmentId;

	private String createdDate;
	
	private Long patientProcedureId;
	
	private String procedureDetails; 

	public ProcedureDto() {
		super();
	}
	
	public ProcedureDto(Long procedureId, String procedureCode, String procedureDescription,
			Integer procedureIsDepricated, Long appointmentId, String createdDate, Long patientProcedureId,
			String procedureDetails) {
		super();
		this.procedureId = procedureId;
		this.procedureCode = procedureCode;
		this.procedureDescription = procedureDescription;
		this.procedureIsDepricated = procedureIsDepricated;
		this.appointmentId = appointmentId;
		this.createdDate = createdDate;
		this.patientProcedureId = patientProcedureId;
		this.procedureDetails = procedureDetails;
	}

	public Long getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}

	public String getProcedureDescription() {
		return procedureDescription;
	}

	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}

	public Integer getProcedureIsDepricated() {
		return procedureIsDepricated;
	}

	public void setProcedureIsDepricated(Integer procedureIsDepricated) {
		this.procedureIsDepricated = procedureIsDepricated;
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

	public Long getPatientProcedureId() {
		return patientProcedureId;
	}

	public void setPatientProcedureId(Long patientProcedureId) {
		this.patientProcedureId = patientProcedureId;
	}

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}
	

	
}
