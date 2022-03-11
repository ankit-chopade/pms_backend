package com.pms.visit.entity;

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
import lombok.ToString;

@Entity
@Table(name = "Vital_Signs")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VitalSignEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Vital_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vitalId;

	@Column(name = "Height")
	private Integer height;

	@Column(name = "Weight")
	private Integer weight;

	@Column(name = "Blood_Pressure")
	private String bloodPressure;

	@Column(name = "Body_Temperature")
	private String bodyTemperature;

	@Column(name = "Respiration_Rate")
	private String respirationRate;

	@Column(name = "Appointment_Id")
	private Long appointmentId;

}
