package com.pms.dto;

public class ProcedureDto {

	private Long procedureId;

	private String procedureCode;

	private String procedureDescription;

	private Integer procedureIsDepricated;

	public ProcedureDto(Long procedureId, String procedureCode, String procedureDescription,
			Integer procedureIsDepricated) {
		super();
		this.procedureId = procedureId;
		this.procedureCode = procedureCode;
		this.procedureDescription = procedureDescription;
		this.procedureIsDepricated = procedureIsDepricated;
	}

	public ProcedureDto() {
		super();
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

	
}
