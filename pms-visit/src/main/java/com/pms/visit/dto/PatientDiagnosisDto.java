package com.pms.visit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDiagnosisDto {

	private Long patientDiagnosisId;

	private Long diagnosisId;

	private Long appointmentId;

	private String diagnosisDetails;

}
