package com.pms.controller;

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

import com.pms.common.entity.ApiResponse;
import com.pms.common.exception.CustomException;
import com.pms.common.util.ResponseUtil;
import com.pms.dto.IdDto;
import com.pms.entity.EditHistoryEntity;
import com.pms.entity.PatientAppointmentEntity;
import com.pms.entity.PatientEntity;
import com.pms.service.SchedulingService;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class SchedulingController {
	
	@Autowired
	private SchedulingService  schedulingService;
	
	@GetMapping("/getPhysician")
	public ResponseEntity<ApiResponse> getPhysician(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Physician Data Fetched Successful", schedulingService.getPhysician());
	}
	
	@PostMapping("/savePatientAppointment")
	public ResponseEntity<ApiResponse> savePatientAppointment(@RequestBody PatientAppointmentEntity patientAppointment) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment Saved Successful", schedulingService.savePatientAppointment(patientAppointment));
	}
	
	@PostMapping("/getPhysicianAppointments")
	public ResponseEntity<ApiResponse> getPhysicianAppintments(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment retrived Successful", schedulingService.getPhysicianAppintments(idDto.getId()));
	}
	
	@PostMapping("/editPatientAppointment")
	public ResponseEntity<ApiResponse> editPatientAppointment(@RequestBody PatientAppointmentEntity patientAppointment) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment edited Successful", schedulingService.editPatientAppointment(patientAppointment));
	}
	
	@PostMapping("/deletePhysicianAppointment")
	public ResponseEntity<ApiResponse> deletePhysicianAppointment(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment retrived Successful", schedulingService.deletePhysicianAppointment(idDto.getId()));
	}
	

	@PostMapping("/edithistory")
	public ResponseEntity<ApiResponse> saveEditHistory(@RequestBody EditHistoryEntity editHistoryEntity) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.CREATED, "History saved Successful", schedulingService.saveEditHistory(editHistoryEntity));
	}
	
	@PostMapping("/edithistorypatient")
	public ResponseEntity<ApiResponse> getEditHistory(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "History retrived Successful", schedulingService.getEditHistory(idDto.getId()));
	}
	
	@GetMapping("/getPatient")
	public ResponseEntity<ApiResponse> getPatient(){
		return ResponseUtil.getResponse(HttpStatus.OK, "Patient Data Fetched Successful", schedulingService.getPatient());
	}
	
	@PostMapping("/getPatientAppointments")
	public ResponseEntity<ApiResponse> getPatientAppintments(@RequestBody IdDto idDto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, "Appointment retrived Successful", schedulingService.getPatientAppintments(idDto.getId()));
	}
}

