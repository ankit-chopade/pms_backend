
package com.pms.procedure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.procedure.constants.PmsProcedureConstants;
import com.pms.procedure.constants.PmsProcedureUrlConstants;
import com.pms.procedure.service.ProcedureService;
import com.pms.procedure.utils.ApiResponse;
import com.pms.procedure.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = PmsProcedureConstants.PMS_CROSS_ORIGIN)
public class ProcedureController {

	@Autowired
	private ProcedureService service;

	@GetMapping(PmsProcedureUrlConstants.URL_PROCEDURE)
	public ResponseEntity<ApiResponse> getAllDetails(){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsProcedureConstants.PMS_RECORDS_FETCHED,
				this.service.getAllDetails());
	}
	

	
	
}