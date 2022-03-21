package com.pms.visit.controller;

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

import com.pms.visit.constants.PmsVisitConstants;
import com.pms.visit.constants.PmsVisitUrlConstants;
import com.pms.visit.dto.VitalSignDto;
import com.pms.visit.service.VitalSignService;
import com.pms.visit.utils.ApiResponse;
import com.pms.visit.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(PmsVisitUrlConstants.URL_VISIT)
public class VitalSignController {

	@Autowired
	private VitalSignService service;

	@GetMapping(PmsVisitUrlConstants.URL_VITIAL_SIGN)
	public ResponseEntity<ApiResponse> getDetailByAppointmentId(@RequestParam Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getDetailByAppointmentId(id));
	}
	

	@PostMapping(PmsVisitUrlConstants.URL_VITIAL_SIGN)
	public ResponseEntity<ApiResponse> saveVitalSigns(@RequestBody VitalSignDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "vital signs added Successfully ",
				this.service.saveVitalSigns(dto));
	}
	
	@GetMapping(PmsVisitUrlConstants.URL_BLOOD_PRESSURE_LIST)
	public ResponseEntity<ApiResponse> getBloodPressureList(@RequestParam Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getBloodPressure(id));
	}
	
	@GetMapping(PmsVisitUrlConstants.URL_RESPIRATION_RATE_LIST)
	public ResponseEntity<ApiResponse> getRespirationRateList(@RequestParam Long id)  {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getRespirationRate(id));
	}
	
	@GetMapping(PmsVisitUrlConstants.URL_LATEST_VITAL_SIGN)
	public ResponseEntity<ApiResponse> getLatestVitalSigns(@RequestParam Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, PmsVisitConstants.PMS_RECORDS_FETCHED,
				this.service.getLatestVitalSigns(id));
	}

}