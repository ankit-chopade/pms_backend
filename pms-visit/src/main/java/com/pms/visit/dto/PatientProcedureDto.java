package com.pms.visit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientProcedureDto {

	private Long procedureId;

	private Long appointmentId;

	private String procedureDetails;

}
