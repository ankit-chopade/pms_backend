package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vital_Signs")
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

	public VitalSignEntity() {
		super();
	}

	public Long getVitalId() {
		return vitalId;
	}

	public void setVitalId(Long vitalId) {
		this.vitalId = vitalId;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(String respirationRate) {
		this.respirationRate = respirationRate;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public VitalSignEntity(Long vitalId, Integer height, Integer weight, String bloodPressure, String bodyTemperature,
			String respirationRate, Long appointmentId) {
		super();
		this.vitalId = vitalId;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.bodyTemperature = bodyTemperature;
		this.respirationRate = respirationRate;
		this.appointmentId = appointmentId;
	}

	

	
}
