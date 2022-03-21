package com.pms.schedule.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.schedule.dto.NurseAppointmentInboxDto;
import com.pms.schedule.dto.PatientAppointmentInboxDto;
import com.pms.schedule.dto.PhysicianAppointmentInboxDto;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.utils.PmsScheduleUtil;

@Service
public class AppointmentInboxServiceImpl implements AppointmentInboxService {

	@Autowired
	PatientAppointmentRepository appointmentRepository;

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

		return list.stream().map(obj -> 

			new NurseAppointmentInboxDto(PmsScheduleUtil.convertObjectIntoLong(obj[0]),
					PmsScheduleUtil.convertObjectIntoString(obj[1]), PmsScheduleUtil.convertObjectIntoString(obj[2]),
					PmsScheduleUtil.convertObjectIntoString(obj[3]), PmsScheduleUtil.convertObjectIntoLong(obj[4]),
					PmsScheduleUtil.convertObjectIntoString(obj[5]), PmsScheduleUtil.convertObjectIntoString(obj[6]))
		).collect(Collectors.toList());
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

		return list.stream().map(obj -> 

			new PatientAppointmentInboxDto(
					PmsScheduleUtil.convertObjectIntoLong(obj[0]), PmsScheduleUtil.convertObjectIntoString(obj[1]),
					PmsScheduleUtil.convertObjectIntoString(obj[2]), PmsScheduleUtil.convertObjectIntoString(obj[3]),
					PmsScheduleUtil.convertObjectIntoLong(obj[4]), PmsScheduleUtil.convertObjectIntoString(obj[5]))
		).collect(Collectors.toList());
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
		return list.stream().map(obj -> 

			new PhysicianAppointmentInboxDto(
					PmsScheduleUtil.convertObjectIntoLong(obj[0]), PmsScheduleUtil.convertObjectIntoString(obj[1]),
					PmsScheduleUtil.convertObjectIntoString(obj[2]), PmsScheduleUtil.convertObjectIntoString(obj[3]),
					PmsScheduleUtil.convertObjectIntoLong(obj[4]), PmsScheduleUtil.convertObjectIntoString(obj[5]))
		).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public Long deleteAppointment(Long appointmentId) {
		return appointmentRepository.deleteByAppointmentId(appointmentId);
	}

}
