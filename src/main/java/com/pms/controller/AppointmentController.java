package com.pms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.exception.CustomException;
import com.pms.common.util.PmsConstant;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.IdDto;
import com.pms.service.AppointmentServiceInteface;
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class AppointmentController {

	
	private Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	AppointmentServiceInteface appointmentService;
	 	
	/**
	 * This API is use to get appointment of Nurse
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(path = "/getAppointmentToPatientByDate")
	public ResponseEntity<ApiResponse> getAppointmentsByDateToPatient(@RequestParam String date){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.appointmentService.getAppointmentsByDate(date));

	}
	
	/**
	 * This API is use to get appointment of Patient
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(path = "/getAppointmentToPatientByDateAndPatientId")
	public ResponseEntity<ApiResponse> getAppointmentsByDateAndPatientId(@RequestParam String date, @RequestParam Long patientId){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.appointmentService.getAppointmentsByDateAndPatientId(date, patientId));
	
	}
	
	/**
	 * This API is use to get appointment of physician
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(path = "/getAppointmentToPatientByDateAndPhysicianId")
	public ResponseEntity<ApiResponse> getAppointmentsByDateAndPhysicianId(@RequestParam String date, @RequestParam Long patientId){
		return ResponseUtil.getResponse(HttpStatus.OK, PmsConstant.PMS_RECORDS_FETCHED,
				this.appointmentService.getAppointmentsByDateAndPhysiciantId(date, patientId));
	
	}

	@DeleteMapping(path ="/delete/appointment")
	public ResponseEntity<ApiResponse> deleteAppointment(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment deleted Successfully", appointmentService.deleteAppointment(idDto.getId()));
	}
}
