package com.pms.procedure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.procedure.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Procedures")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
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

}
