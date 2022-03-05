package com.pms.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientProcedureViewDto {

	private Long procedureId;

	private String procedureCode;

	private String procedureDescription;

	private Integer procedureIsDepricated;

	private Long appointmentId;

	private String createdDate;

	private Long patientProcedureId;

	private String procedureDetails;

}
