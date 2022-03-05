package com.pms.visit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.visit.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patient_Procedures")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PatientProcedureEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Patient_Procedure_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientProcedureId;

	@Column(name = "Procedure_Id")
	private Long procedureId;
	
	@Column(name = "Appointment_Id")
	private Long appointmentId;

	@Column(name = "procedureDetails")
	private String procedureDetails;

}
