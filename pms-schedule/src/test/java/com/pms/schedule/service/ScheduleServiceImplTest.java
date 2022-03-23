package com.pms.schedule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import com.pms.schedule.constants.JunitConstants;
import com.pms.schedule.converter.EditHistoryConverter;
import com.pms.schedule.converter.EditHistorySaveConverter;
import com.pms.schedule.converter.PatientAppointmentConverter;
import com.pms.schedule.dto.EditHistoryDto;
import com.pms.schedule.dto.EditHistorySaveDto;
import com.pms.schedule.dto.NurseAppointmentInboxDto;
import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.dto.PatientAppointmentInboxDto;
import com.pms.schedule.dto.PhysicianAppointmentInboxDto;
import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.entity.UserEntity;
import com.pms.schedule.repository.EditHistoryRepository;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.repository.UserRepository;
import com.pms.schedule.utils.CustomException;
import com.pms.schedule.utils.PmsScheduleUtil;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {

	@InjectMocks
	private ScheduleServiceImpl service;

	@Mock
	private EditHistoryRepository editHistoryRepository;
	
	@Mock
	private PatientAppointmentRepository patientAppointmentRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private EditHistoryEntity editHistoryEntity;

	
	@Mock
	private PatientAppointmentEntity patientAppointmentEntity;
	
	@Mock
	private UserEntity userEntity;
	
	
	@Mock
	private EditHistoryDto editHistoryDto;
	
	@Mock
	private EditHistorySaveDto editHistorySaveDto;

	@Mock
	private PatientAppointmentDto patientAppointmentDto;

	
	@Mock
	private EditHistoryConverter editHistoryConverter;
	
	@Mock
	private EditHistorySaveConverter editHistorySaveConverter;
	
	@Mock
	private  PatientAppointmentConverter patientAppointmentConverter;
	
	@Mock
	private JavaMailSender mailSender;
	
	@Mock
	private PmsScheduleUtil pmsUtil;
	
	@InjectMocks
	private AppointmentInboxServiceImpl inboxService;

	@Mock
	private PatientAppointmentRepository appointmentRepository;

	@Mock
	private PatientAppointmentEntity appointmentEntity;

	@Mock
	private NurseAppointmentInboxDto nurseAppointmentDto;

	@Mock
	private PhysicianAppointmentInboxDto physicianAppointmentDto;
	
	@Test
	void testGetPhysician() {
		List<UserEntity> entityList = new ArrayList<>();
		when(userRepository.findByRoleId(3)).thenReturn(entityList);
		assertNotNull(service.getPhysician());
	}

	@Test
	void testSavePatientAppointment() throws CustomException {
		when(patientAppointmentConverter.toEntity(patientAppointmentDto)).thenReturn(patientAppointmentEntity);
		when(patientAppointmentRepository.save(patientAppointmentEntity)).thenReturn(patientAppointmentEntity);
		when(patientAppointmentConverter.toDto(patientAppointmentEntity)).thenReturn(patientAppointmentDto);
		assertNotNull(service.savePatientAppointment(patientAppointmentDto));		
	}

	@Test
	void testGetPhysicianAppintments() throws CustomException {
		List<PatientAppointmentEntity> entityList = new ArrayList<>();
		List<PatientAppointmentDto> dtoList = new ArrayList<>();
		when(patientAppointmentRepository.findByPhysicianId(JunitConstants.LONG_TYPE)).thenReturn(entityList);
		when(patientAppointmentConverter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getPhysicianAppintments(JunitConstants.LONG_TYPE));
	}

	@Test
	void testEditPatientAppointment() throws CustomException {
		when(patientAppointmentRepository.findByAppointmentId(patientAppointmentDto.getAppointmentId())).thenReturn(patientAppointmentEntity);
		when(patientAppointmentRepository.save(patientAppointmentEntity)).thenReturn(patientAppointmentEntity);
		when(patientAppointmentConverter.toDto(patientAppointmentEntity)).thenReturn(patientAppointmentDto);
		assertNotNull(service.editPatientAppointment(patientAppointmentDto));

	}

	@Test
	void testDeletePhysicianAppointment() throws CustomException {
		when(patientAppointmentRepository.deleteByAppointmentId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.deletePhysicianAppointment(JunitConstants.LONG_TYPE));

	}

	@Test
	void testSaveEditHistory() throws CustomException {
		when(editHistorySaveConverter.toEntity(editHistorySaveDto)).thenReturn(editHistoryEntity);
		when(editHistoryRepository.save(editHistoryEntity)).thenReturn(editHistoryEntity);
		when(editHistorySaveConverter.toDto(editHistoryEntity)).thenReturn(editHistorySaveDto);
		assertNotNull(service.saveEditHistory(editHistorySaveDto));

	
	}

	@Test
	void testGetEditHistory() throws CustomException {
		List<EditHistoryEntity> entityList = new ArrayList<>();
		EditHistoryEntity entity = new EditHistoryEntity();
		entity.setPatientId(JunitConstants.LONG_TYPE);
		entity.setPhysicianId(JunitConstants.LONG_TYPE);
		entity.setEditedBy(JunitConstants.LONG_TYPE);
		entityList.add(entity);
		
		when(editHistoryRepository.findByPatientId(JunitConstants.LONG_TYPE)).thenReturn(entityList);
		
		when(userRepository.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(userEntity));
//		Optional<UserEntity> userEntityOptinal = Optional.ofNullable(null);
//		when(userEntityOptinal.get()).thenReturn(entity);
		when(userEntity.getFirstName()).thenReturn(JunitConstants.STRING_TYPE);
		when(userEntity.getLastName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getEditHistory(JunitConstants.LONG_TYPE));

		

	}

	@Test
	void testGetPatient() {
		List<UserEntity> entityList = new ArrayList<>();
		when(userRepository.findByRoleId(5)).thenReturn(entityList);
		assertNotNull(service.getPatient());
	}

	@Test
	void testGetPatientAppintments() throws CustomException {
		List<PatientAppointmentEntity> entityList = new ArrayList<>();
		List<PatientAppointmentDto> dtoList = new ArrayList<>();
		when(patientAppointmentRepository.findByPatientId(JunitConstants.LONG_TYPE)).thenReturn(entityList);
		when(patientAppointmentConverter.toDto(entityList)).thenReturn(dtoList);
		assertNotNull(service.getPatientAppintments(JunitConstants.LONG_TYPE));
	}
	/**
	 * Inbox Testing
	 */
	
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
