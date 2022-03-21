package com.pms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.schedule.constants.PmsScheduleConstants;
import com.pms.schedule.constants.PmsScheduleUrlConstants;
import com.pms.schedule.dto.EditHistorySaveDto;
import com.pms.schedule.dto.IdDto;
import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.service.ScheduleService;
import com.pms.schedule.utils.ApiResponse;
import com.pms.schedule.utils.CustomException;
import com.pms.schedule.utils.ResponseUtil;


@RestController
@RequestMapping(PmsScheduleUrlConstants.URL_ROOT)
@CrossOrigin(origins=PmsScheduleConstants.PMS_CROSS_ORIGIN,allowedHeaders = "*")
public class ScheduleController {
	
	@Autowired
	private ScheduleService  schedulingService;
	
	@GetMapping(PmsScheduleUrlConstants.URL_GET_PHYSICIANS)
	public ResponseEntity<ApiResponse> getPhysician(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Physician Data Fetched Successful", schedulingService.getPhysician());
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_SAVE_APPOINTMENT)
	public ResponseEntity<ApiResponse> savePatientAppointment(@RequestBody PatientAppointmentDto patientAppointment) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment Saved Successful", schedulingService.savePatientAppointment(patientAppointment));
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_GET_APPOINTMENT)
	public ResponseEntity<ApiResponse> getPhysicianAppintments(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment retrived Successful", schedulingService.getPhysicianAppintments(idDto.getId()));
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_EDIT_APPOINTMENT)
	public ResponseEntity<ApiResponse> editPatientAppointment(@RequestBody PatientAppointmentDto patientAppointment) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment edited Successful", schedulingService.editPatientAppointment(patientAppointment));
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_DELETE_APPOINTMENT)
	public ResponseEntity<ApiResponse> deletePhysicianAppointment(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment deleted Successfully", schedulingService.deletePhysicianAppointment(idDto.getId()));
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_EDIT_HISTORY)
	public ResponseEntity<ApiResponse> saveEditHistory(@RequestBody EditHistorySaveDto editHistoryEntity) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.CREATED, "History saved Successful", schedulingService.saveEditHistory(editHistoryEntity));
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_GET_EDIT_HISTORY)
	public ResponseEntity<ApiResponse> getEditHistory(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "History retrived Successful", schedulingService.getEditHistory(idDto.getId()));
	}
	@GetMapping(PmsScheduleUrlConstants.URL_GET_PATIENTS)
	public ResponseEntity<ApiResponse> getPatient(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Patient Data Fetched Successful", schedulingService.getPatient());
	}
	
	@PostMapping(PmsScheduleUrlConstants.URL_GET_PATIENT_APPOINTMENT)
	public ResponseEntity<ApiResponse> getPatientAppintments(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment retrived Successful", schedulingService.getPatientAppintments(idDto.getId()));
	}
}

