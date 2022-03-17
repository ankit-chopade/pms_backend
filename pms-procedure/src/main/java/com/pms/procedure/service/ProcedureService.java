package com.pms.procedure.service;

import java.util.List;

import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.utils.CustomException;

public interface ProcedureService {

	public List<ProcedureDto> getAllDetails();

	public ProcedureDto saveProcedure(ProcedureDto dto) throws CustomException;
	
	public ProcedureDto updateProcedure(ProcedureDto dto) ;
	
	public ProcedureDto deleteProcedure(Long id) throws CustomException;
	
	public List<ProcedureDto> getAllNonDepricatedDetails();
}
