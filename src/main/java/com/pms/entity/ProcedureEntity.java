package com.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Procedures")
public class ProcedureEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Procedure_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long procedureId;

	@Column(name = "Procedure_Code")
	private String procedureCode;

	@Column(name = "Procedure_Description")
	private String procedureDescription;

	@Column(name = "Procedure_Is_Depricated")
	private Integer procedureIsDepricated;

	public ProcedureEntity() {
		super();
	}

	public ProcedureEntity(Long procedureId, String procedureCode, String procedureDescription,
			Integer procedureIsDepricated) {
		super();
		this.procedureId = procedureId;
		this.procedureCode = procedureCode;
		this.procedureDescription = procedureDescription;
		this.procedureIsDepricated = procedureIsDepricated;
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

	@Override
	public String toString() {
		return "ProcedureEntity [procedureId=" + procedureId + ", procedureCode=" + procedureCode
				+ ", procedureDescription=" + procedureDescription + ", procedureIsDepricated=" + procedureIsDepricated
				+ "]";
	}

}
