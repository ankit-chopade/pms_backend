package com.pms.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.PmsConstant;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.PatientAppointmentDto;
import com.pms.entity.PatientAppointmentEntity;
import com.pms.service.AppointmentServiceInteface;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class AppointmentController {

	
	private Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	AppointmentServiceInteface appointmentService;

	/**
	 * This API is use to get all appointments of physician
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */

	@GetMapping(path = "/getAppointmentToPhysician")
	@ApiOperation(value = "Fetch Physician Appointment", notes = "Provide Date In Range (From-To)")

	public ResponseEntity<ApiResponse> getAppointmentToPhysician(
			@ApiParam(value = "Physician Id/startDate/endDate", required = true) @RequestParam Long physicianId,
			@ApiParam(value = "Start Date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@ApiParam(value = "End Date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		
			log.info("Getting all appointment of physician from {Startdate} - {Enddate}");
			return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED, this.appointmentService.getAppointmentToPhysician(physicianId, startDate, endDate));
	}
	
	/**
	 * This API is use to get all appointments of patient
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */

	@GetMapping(path = "/getAppointmentToPatient")
	@ApiOperation(value = "Fetch Patient Appointment", notes = "Provide Date In Range (From-To)")
	public ResponseEntity<ApiResponse> getAppointmentToPatient(
			@ApiParam(value = "Patient Id", required = true) @RequestParam Long patientId,
			@ApiParam(value = "Start Date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd")  @RequestParam LocalDate startDate,
			@ApiParam(value = "End Date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate endDate) {

		
			log.info("Getting all appointment of patient from {Startdate} - {Enddate}");
			return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED, this.appointmentService.getAppointmentToPatient(patientId, startDate, endDate));

	}


	/**
	 * This API is use to get appointment of physician
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */

	@GetMapping(path = "/getAppointmentById")
	@ApiOperation(value = "Fetch An Existing Appointment", notes = "Provide Date In Range (From-To {Date})")
	public ResponseEntity<PatientAppointmentDto> getAppointmentById(

			@ApiParam(value = "Appointment Id", required = true) @RequestParam Long id) {
		try {

			log.info("Get AppointmentById");
			PatientAppointmentDto appointmentDto = appointmentService.getAppointmentById(id);
			log.info("Sending response getAppointmentById ");
			return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception happen" + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(path = "/getAppointmentToPatientByDate")
	public ResponseEntity<ApiResponse> getAppointmentsByDateToPatient(@RequestParam String date){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.appointmentService.getAppointmentsByDate(date));

	}
	
//	@GetMapping(path = "/getAppointmentsByDateToPhysician")
//	public ResponseEntity<ApiResponse> getAppointmentsByDateToPhysician(@RequestParam String date){
//		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
//				this.appointmentService.getAppointmentsByDate(date));
//
//	}
//	
//	@GetMapping(path = "/getAppointmentsByDateToNurse")
//	public ResponseEntity<ApiResponse> getAppointmentsByDateToNurse(@RequestParam String date){
//		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
//				this.appointmentService.getAppointmentsByDateToNurse(date));
//
//	}
}
