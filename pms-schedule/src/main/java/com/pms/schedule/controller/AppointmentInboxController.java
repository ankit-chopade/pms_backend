package com.pms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.schedule.constants.PmsScheduleUrlConstants;
import com.pms.schedule.dto.IdDto;
import com.pms.schedule.service.AppointmentInboxService;
import com.pms.schedule.utils.ApiResponse;
import com.pms.schedule.utils.CustomException;
import com.pms.schedule.utils.ResponseUtil;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping(PmsScheduleUrlConstants.URL_ROOT)

public class AppointmentInboxController {

	@Autowired
	AppointmentInboxService appointmentService;

	/**
	 * This API is use to get appointment of Nurse
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(PmsScheduleUrlConstants.URL_INBOX_NURSE)
	public ResponseEntity<ApiResponse> getAppointmentsByDateToPatient(@RequestParam String date) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.appointmentService.getAppointmentsByDate(date));

	}

	/**
	 * This API is use to get appointment of Patient
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(PmsScheduleUrlConstants.URL_INBOX_PATIENT)
	public ResponseEntity<ApiResponse> getAppointmentsByDateAndPatientId(@RequestParam String date,
			@RequestParam Long patientId) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.appointmentService.getAppointmentsByDateAndPatientId(date, patientId));

	}

	/**
	 * This API is use to get appointment of physician
	 * 
	 * @author AbhijeetR
	 * @param
	 * @return
	 */
	@GetMapping(PmsScheduleUrlConstants.URL_INBOX_PHYSICIAN)
	public ResponseEntity<ApiResponse> getAppointmentsByDateAndPhysicianId(@RequestParam String date,
			@RequestParam Long physicianId) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched Successful",
				this.appointmentService.getAppointmentsByDateAndPhysiciantId(date, physicianId));

	}

	@DeleteMapping(path = "/delete/appointment")
	public ResponseEntity<ApiResponse> deleteAppointment(@RequestParam Long appointmentId) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment deleted Successfully",
				appointmentService.deleteAppointment(appointmentId));
	}
}
