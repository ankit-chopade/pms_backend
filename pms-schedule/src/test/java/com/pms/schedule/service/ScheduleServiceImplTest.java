package com.pms.schedule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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
import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.entity.UserEntity;
import com.pms.schedule.repository.EditHistoryRepository;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.repository.UserRepository;
import com.pms.schedule.utils.CustomException;

@ExtendWith(MockitoExtension.class)
public class ScheduleServiceImplTest {

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
		
		when(userRepository.findByUserId(patientAppointmentEntity.getPatientId())).thenReturn(Optional.of(userEntity));
		when(userRepository.findByUserId(patientAppointmentEntity.getPhysicianId())).thenReturn(Optional.of(userEntity));
//		when(patientAppointmentConverter.toDto(patientAppointmentEntity)).thenReturn(patientAppointmentDto);
		
		CustomException customException = assertThrows(CustomException.class,() -> service.savePatientAppointment(patientAppointmentDto));
		assertEquals(JunitConstants.MESSAGE_TYPE, customException.getMessage());
		
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

}
