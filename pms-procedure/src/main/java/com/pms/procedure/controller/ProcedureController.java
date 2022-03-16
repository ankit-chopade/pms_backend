
package com.pms.procedure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.procedure.constants.PmsProcedureConstants;
import com.pms.procedure.constants.PmsProcedureUrlConstants;
import com.pms.procedure.dto.ProcedureDto;
import com.pms.procedure.service.ProcedureService;
import com.pms.procedure.utils.ApiResponse;
import com.pms.procedure.utils.CustomException;
import com.pms.procedure.utils.ResponseUtil;

@RestController
@RequestMapping(PmsProcedureUrlConstants.URL_PROCEDURE)
@CrossOrigin(origins = PmsProcedureConstants.PMS_CROSS_ORIGIN)
public class ProcedureController {

	@Autowired
	private ProcedureService service;

	@GetMapping()
	public ResponseEntity<ApiResponse> getAllDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}
	
	@PostMapping()
	public ResponseEntity<ApiResponse> saveProcedure(@RequestBody ProcedureDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.saveProcedure(dto));
	}
	
	@PutMapping()
	public ResponseEntity<ApiResponse> updateProcedure(@RequestBody ProcedureDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.updateProcedure(dto));
	}
	
	@DeleteMapping()
	public ResponseEntity<ApiResponse> deleteProcedure(@RequestParam Long id) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.deleteProcedure(id));
	}

	
	@GetMapping("/getNonDepricated")
	public ResponseEntity<ApiResponse> getAllNonDepricatedDetails() {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.getAllNonDepricatedDetails());
	}

	
	
}