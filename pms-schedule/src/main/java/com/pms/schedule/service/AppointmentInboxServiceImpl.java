package com.pms.schedule.service;

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

import com.pms.schedule.dto.NurseAppointmentInboxDto;
import com.pms.schedule.dto.PatientAppointmentInboxDto;
import com.pms.schedule.dto.PhysicianAppointmentInboxDto;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.utils.PmsScheduleUtil;

@Service
public class AppointmentInboxServiceImpl implements AppointmentInboxService {

	@Autowired
	PatientAppointmentRepository appointmentRepository;

	private Logger log = LoggerFactory.getLogger(AppointmentInboxServiceImpl.class);

	// Nurse

	@Override
	public List<NurseAppointmentInboxDto> getAppointmentsByDate(String customDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		try {
			date = formatter.parse(customDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Object[]> list = appointmentRepository.getAppointmentsByDate(date);

		List<NurseAppointmentInboxDto> dto = list.stream().map(obj -> {

			NurseAppointmentInboxDto data = new NurseAppointmentInboxDto(PmsScheduleUtil.convertObjectIntoLong(obj[0]),
					PmsScheduleUtil.convertObjectIntoString(obj[1]), PmsScheduleUtil.convertObjectIntoString(obj[2]),
					PmsScheduleUtil.convertObjectIntoString(obj[3]), PmsScheduleUtil.convertObjectIntoLong(obj[4]),
					PmsScheduleUtil.convertObjectIntoString(obj[5]), PmsScheduleUtil.convertObjectIntoString(obj[6]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	@Override
	public List<PatientAppointmentInboxDto> getAppointmentsByDateAndPatientId(String customDate, Long patientId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(customDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Object[]> list = appointmentRepository.getAppointmentsByDateAndPatientId(date, patientId);

		List<PatientAppointmentInboxDto> dto = list.stream().map(obj -> {

			PatientAppointmentInboxDto data = new PatientAppointmentInboxDto(
					PmsScheduleUtil.convertObjectIntoLong(obj[0]), PmsScheduleUtil.convertObjectIntoString(obj[1]),
					PmsScheduleUtil.convertObjectIntoString(obj[2]), PmsScheduleUtil.convertObjectIntoString(obj[3]),
					PmsScheduleUtil.convertObjectIntoLong(obj[4]), PmsScheduleUtil.convertObjectIntoString(obj[5]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	@Override
	public List<PhysicianAppointmentInboxDto> getAppointmentsByDateAndPhysiciantId(String customDate,
			Long physicianId) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(customDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Object[]> list = appointmentRepository.getAppointmentsByDateAndPhysicianId(date, physicianId);
		List<PhysicianAppointmentInboxDto> dto = list.stream().map(obj -> {

			PhysicianAppointmentInboxDto data = new PhysicianAppointmentInboxDto(
					PmsScheduleUtil.convertObjectIntoLong(obj[0]), PmsScheduleUtil.convertObjectIntoString(obj[1]),
					PmsScheduleUtil.convertObjectIntoString(obj[2]), PmsScheduleUtil.convertObjectIntoString(obj[3]),
					PmsScheduleUtil.convertObjectIntoLong(obj[4]), PmsScheduleUtil.convertObjectIntoString(obj[5]));
			return data;
		}).collect(Collectors.toList());

		return dto;
	}

	@Transactional
	@Override
	public Long deleteAppointment(Long appointmentId) {
		Long deltetedAppointment = appointmentRepository.deleteByAppointmentId(appointmentId);
		return deltetedAppointment;
	}

}
