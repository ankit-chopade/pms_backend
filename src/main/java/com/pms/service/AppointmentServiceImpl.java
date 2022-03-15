package com.pms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.dto.NurseAppointmentDto;
import com.pms.dto.PatientAppointmentDto;
import com.pms.dto.PhysicianAppointmentDto;
import com.pms.repository.PatientAppointmentRepository;
import com.pms.util.PmsUtil;

@Service
public class AppointmentServiceImpl implements AppointmentServiceInteface {

	@Autowired
	PatientAppointmentRepository appointmentRepository;

	@Autowired
	RestTemplate restTemplate;

	private Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);

	
	@Override
	public List<NurseAppointmentDto> getAppointmentsByDate(String customDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		try {
			date = formatter.parse(customDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Object[]> list = appointmentRepository.getAppointmentsByDate(date);

		List<NurseAppointmentDto> dto = list.stream().map(obj -> {

			NurseAppointmentDto data = new NurseAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoString(obj[3]), PmsUtil.convertObjectIntoLong(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]),PmsUtil.convertObjectIntoString(obj[6]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	@Override
	public List<PatientAppointmentDto> getAppointmentsByDateAndPatientId(String customDate, Long patientId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(customDate);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Object[]> list = appointmentRepository.getAppointmentsByDateAndPatientId(date, patientId);
		
		List<PatientAppointmentDto> dto = list.stream().map(obj -> {

			PatientAppointmentDto data = new PatientAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoString(obj[3]), PmsUtil.convertObjectIntoLong(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	@Override
	public List<PhysicianAppointmentDto> getAppointmentsByDateAndPhysiciantId(String customDate, Long physicianId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(customDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Object[]> list = appointmentRepository.getAppointmentsByDateAndPhysicianId(date, physicianId);
		List<PhysicianAppointmentDto> dto = list.stream().map(obj -> {

			PhysicianAppointmentDto data = new PhysicianAppointmentDto(PmsUtil.convertObjectIntoLong(obj[0]),
					PmsUtil.convertObjectIntoString(obj[1]), PmsUtil.convertObjectIntoString(obj[2]),
					PmsUtil.convertObjectIntoString(obj[3]), PmsUtil.convertObjectIntoLong(obj[4]),
					PmsUtil.convertObjectIntoString(obj[5]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	

	
	@Transactional
	@Override
	public Long deleteAppointment(Long id) {
		Long deltetedAppointment = appointmentRepository.deleteByAppointmentId(id);
		return deltetedAppointment;
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
