package com.pms.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.schedule.constants.JunitConstants;
import com.pms.schedule.dto.NurseAppointmentInboxDto;
import com.pms.schedule.dto.PatientAppointmentInboxDto;
import com.pms.schedule.dto.PhysicianAppointmentInboxDto;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.service.AppointmentInboxServiceImpl;
import com.pms.schedule.utils.PmsScheduleUtil;

@ExtendWith(MockitoExtension.class)
class AppointmentInboxServiceImplTest {

	@InjectMocks
	private AppointmentInboxServiceImpl inboxService;

	@Mock
	private PatientAppointmentRepository appointmentRepository;

	@Mock
	private PatientAppointmentEntity appointmentEntity;

	@Mock
	private NurseAppointmentInboxDto nurseAppointmentDto;

	@Mock
	private PatientAppointmentInboxDto patientAppointmentDto;

	@Mock
	private PhysicianAppointmentInboxDto physicianAppointmentDto;

	@Mock
	private PmsScheduleUtil pmsUtil;

	@Test
	void testGetAppointmentsByDateTest() throws ParseException {
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] objArray= new Object[7];
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		objArray[2] = JunitConstants.STRING_TYPE;
		objArray[3] = JunitConstants.STRING_TYPE;
		objArray[4] = JunitConstants.LONG_TYPE;
		objArray[5] = JunitConstants.STRING_TYPE;
		objArray[6] = JunitConstants.STRING_TYPE;
		list.add(objArray);
		when(appointmentRepository.getAppointmentsByDate(null)).thenReturn(list);
		assertNotNull(inboxService.getAppointmentsByDate(JunitConstants.DATE_STRING_TYPE));
	}

	@Test
	void testDeleteAppointment() {
		when(appointmentRepository.deleteByAppointmentId(JunitConstants.LONG_TYPE))
				.thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(inboxService.deleteAppointment(JunitConstants.LONG_TYPE));
	} 
	@Test
	void testGetAppointmentsByDateAndPatientId() throws ParseException {
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] objArray= new Object[6];
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		objArray[2] = JunitConstants.STRING_TYPE;
		objArray[3] = JunitConstants.STRING_TYPE;
		objArray[4] = JunitConstants.LONG_TYPE;
		objArray[5] = JunitConstants.STRING_TYPE;
		list.add(objArray);
		when(appointmentRepository.getAppointmentsByDateAndPatientId(null,JunitConstants.LONG_TYPE)).thenReturn(list);
		assertNotNull(inboxService.getAppointmentsByDateAndPatientId(JunitConstants.DATE_STRING_TYPE ,JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testGetAppointmentsByDateAndPhysiciantId() throws ParseException{
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] objArray= new Object[6];
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		objArray[2] = JunitConstants.STRING_TYPE;
		objArray[3] = JunitConstants.STRING_TYPE;
		objArray[4] = JunitConstants.LONG_TYPE;
		objArray[5] = JunitConstants.STRING_TYPE;
		list.add(objArray);
		when(appointmentRepository.getAppointmentsByDateAndPhysicianId(null, JunitConstants.LONG_TYPE)).thenReturn(list);
		assertNotNull(inboxService.getAppointmentsByDateAndPhysiciantId(JunitConstants.DATE_STRING_TYPE, JunitConstants.LONG_TYPE));
	}
}
