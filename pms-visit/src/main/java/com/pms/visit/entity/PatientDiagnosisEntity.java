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

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient_Diagnosis")
public class PatientDiagnosisEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Patient_Diagnosis_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientDiagnosisId;

	@Column(name = "Diagnosis_Id")
	private Long diagnosisId;

	@Column(name = "Appointment_Id")
	private Long appointmentId;

	@Column(name = "diagnosisDetails")
	private String diagnosisDetails;

}
