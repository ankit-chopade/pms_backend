package com.pms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.dto.PatientAppointmentDto;
import com.pms.entity.PatientAppointmentEntity;
import com.pms.repository.PatientAppointmentRepository;
import com.pms.util.PmsUtil;

@Service
public class AppointmentServiceImpl implements AppointmentServiceInteface{

	
	@Autowired
	PatientAppointmentRepository appointmentRepository;

	@Autowired
	RestTemplate restTemplate;

	private Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	

	@Override
	public List<PatientAppointmentDto> getAppointmentToPhysician(Long physicianId, LocalDate startDate, LocalDate endDate) {
		log.info("Inside getAppointmentToPhysician Service");
		List<Object[]> list =appointmentRepository.getAppointmentToPhysician(physicianId, startDate, endDate);
		List<PatientAppointmentDto> dto = list.stream().map(obj -> {
			PatientAppointmentDto data =null;
			try {
//			data = new PatientAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
//					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]), 
//					PmsUtil.convertObjectIntoLong(obj[3]), PmsUtil.convertObjectIntoString(obj[4]),
//					PmsUtil.parseDate(PmsUtil.convertObjectIntoString(obj[5]), "yyyy-MM-dd"));
			
			}catch (Exception e) {
				e.printStackTrace();
			}return data;
		}).collect(Collectors.toList());
		return dto;
	}
	
	@Override
	public List<PatientAppointmentDto> getAppointmentToPatient(Long patientId, LocalDate startDate, LocalDate endDate) {
		log.info("Inside getAppointmentToPatient Service");
		List<Object[]> list = appointmentRepository.getAppointmentToPatient(patientId, startDate, endDate);
		List<PatientAppointmentDto> dto = list.stream().map(obj -> {
			PatientAppointmentDto data =null;
			try {
//				data = new PatientAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
//						PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]), 
//						PmsUtil.convertObjectIntoLong(obj[3]), PmsUtil.convertObjectIntoString(obj[4]),
//					PmsUtil.parseDate(PmsUtil.convertObjectIntoString(obj[5]), "yyyy-MM-dd"));
//						
			}catch (Exception e) {
               e.printStackTrace();
			}
			return data;
		}).collect(Collectors.toList());
		return dto;
	}



	@Override
	public PatientAppointmentDto getAppointmentById(Long id) {
		log.info("Inside getAppointmentById Service");

		PatientAppointmentEntity apt = appointmentRepository.findById(id).get();
		PatientAppointmentDto dto = new PatientAppointmentDto();
		dto.setAppointmentId(apt.getAppointmentId());
	//	dto.setAppointmentDate(apt.getAppointmentDate());
		dto.setDescription(apt.getDescription());
		dto.setSubject(apt.getSubject());
		dto.setPatientId(apt.getPatientId());
		//dto.setPhysicianId(apt.getPhysicianId());
		return dto;
	}

	@Override
	public List<PatientAppointmentDto> getAppointmentsByDate(String customDate) {
	    SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    
	    Date date = null;
		try {
			date = formatter.parse(customDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Object[]> list = appointmentRepository.getAppointmentsByDate(date);
		
		List<PatientAppointmentDto> dto = list.stream().map(obj -> {
			
			PatientAppointmentDto data = new PatientAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]), 
					PmsUtil.convertObjectIntoString(obj[3]),PmsUtil.convertObjectIntoLong(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]));
		return data;
		 }).collect(Collectors.toList());
		
		return dto;
	}

//	@Override
//	public List<PatientAppointmentDto> getAppointmentsByDateToNurse(String customDate) {
//    
//SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    
//	    Date date = null;
//		try {
//			date = formatter.parse(customDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		List<Object[]> list = appointmentRepository.getAppointmentsByDateToNurse(date);
//		
//		List<PatientAppointmentDto> dto = list.stream().map(obj -> {
//			
//			PatientAppointmentDto data = new PatientAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
//					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]), 
//					PmsUtil.convertObjectIntoString(obj[3]),PmsUtil.convertObjectIntoLong(obj[4]),
//					PmsUtil.convertObjectIntoString(obj[5]));
//		return data;
//		 }).collect(Collectors.toList());
//		
//		return dto;
//	}
	
}
