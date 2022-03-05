package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDiagnosisViewDto {

	private Long diagnosisId;

	private String diagnosisCode;

	private String diagnosisDescription;

	private Integer diagnosisIsDepricated;

	private Long appointmentId;

	private String createdDate;

	private Long patientDiagnosisId;

	private String diagnosisDetails;
}
