package com.pms.diagnosis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiagnosisDto {

	private Long diagnosisId;

	private String diagnosisCode;

	private String diagnosisDescription;

	private Integer diagnosisIsDepricated;

}
