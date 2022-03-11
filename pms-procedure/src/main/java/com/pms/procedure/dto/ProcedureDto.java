package com.pms.procedure.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProcedureDto {

	private Long procedureId;

	private String procedureCode;

	private String procedureDescription;
	
	private Integer procedureIsDepricated;

}
