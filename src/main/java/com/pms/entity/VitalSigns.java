//package com.pms.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//@Entity
//@Table(name = "Vital_Signs")
//public class VitalSigns {
//
//	@Id
//	@Column(name = "Vital_Id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer vitalId;
//	
//	@Column(name = "Height")
//	private Integer height;
//	
//	@Column(name = "Weight")
//	private Integer weight;
//	
//    @Column(name = "Blood_Pressure")
//	private String bloodPressure;
//	
//    @Column(name = "Body_Temprature")
//	private String bodyTemprature;
//    
//    @Column(name = "Respiration_Rate")
//    private String respirationRate;
//    
//	@OneToOne
//	@JoinColumn(nullable = false, name = "FK_PatientVisitDetails")
//	private PatientVisitDetails patientVisitDetails;
//
//	
//	public VitalSigns() {
//		super();
//	}
//
//	public VitalSigns(Integer vitalId, Integer height, Integer weight, String bloodPressure, String bodyTemprature,
//			String respirationRate, PatientVisitDetails patientVisitDetails) {
//		super();
//		this.vitalId = vitalId;
//		this.height = height;
//		this.weight = weight;
//		this.bloodPressure = bloodPressure;
//		this.bodyTemprature = bodyTemprature;
//		this.respirationRate = respirationRate;
//		this.patientVisitDetails = patientVisitDetails;
//	}
//
//	public Integer getVitalId() {
//		return vitalId;
//	}
//
//	public void setVitalId(Integer vitalId) {
//		this.vitalId = vitalId;
//	}
//
//	public Integer getHeight() {
//		return height;
//	}
//
//	public void setHeight(Integer height) {
//		this.height = height;
//	}
//
//	public Integer getWeight() {
//		return weight;
//	}
//
//	public void setWeight(Integer weight) {
//		this.weight = weight;
//	}
//
//	public String getBloodPressure() {
//		return bloodPressure;
//	}
//
//	public void setBloodPressure(String bloodPressure) {
//		this.bloodPressure = bloodPressure;
//	}
//
//	public String getBodyTemprature() {
//		return bodyTemprature;
//	}
//
//	public void setBodyTemprature(String bodyTemprature) {
//		this.bodyTemprature = bodyTemprature;
//	}
//
//	public String getRespirationRate() {
//		return respirationRate;
//	}
//
//	public void setRespirationRate(String respirationRate) {
//		this.respirationRate = respirationRate;
//	}
//
//	public PatientVisitDetails getPatientVisitDetails() {
//		return patientVisitDetails;
//	}
//
//	public void setPatientVisitDetails(PatientVisitDetails patientVisitDetails) {
//		this.patientVisitDetails = patientVisitDetails;
//	}
//
//	@Override
//	public String toString() {
//		return "VitalSigns [vitalId=" + vitalId + ", height=" + height + ", weight=" + weight + ", bloodPressure="
//				+ bloodPressure + ", bodyTemprature=" + bodyTemprature + ", respirationRate=" + respirationRate
//				+ ", patientVisitDetails=" + patientVisitDetails + "]";
//	}
//
//}
