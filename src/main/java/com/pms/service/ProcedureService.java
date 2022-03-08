package com.pms.service;

import java.util.List;

import com.pms.dto.ProcedureDto;

public interface ProcedureService {

	public List<ProcedureDto> getAllDetails();
	public ProcedureDto saveProcedure(ProcedureDto dto);
	public void deleteProcedure(Long procedureId);
}
