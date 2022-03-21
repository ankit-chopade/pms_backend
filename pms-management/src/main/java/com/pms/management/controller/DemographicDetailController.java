package com.pms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.management.constants.DemographicDetailUrlConstants;
import com.pms.management.constants.ManagementUrlConstants;
import com.pms.management.dto.DemographicDetailDto;
import com.pms.management.services.DemographicDetailService;
import com.pms.management.utils.ApiResponse;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.ResponseUtil;


@RestController
@RequestMapping(ManagementUrlConstants.URL_ROOT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DemographicDetailController {

	@Autowired
	private DemographicDetailService patientservice;

	@PostMapping(DemographicDetailUrlConstants.URL_DEMOGRAPHIC)
	public ResponseEntity<ApiResponse> savePatient(@RequestBody DemographicDetailDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Save Successful", this.patientservice.save(dto));

	}

	@GetMapping(DemographicDetailUrlConstants.URL_DEMOGRAPHICBYID) 
	public ResponseEntity<ApiResponse> getDetailsbyUserId(@RequestParam Long userId) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.patientservice.getpatientDetailbyUserId(userId));
	}

}
