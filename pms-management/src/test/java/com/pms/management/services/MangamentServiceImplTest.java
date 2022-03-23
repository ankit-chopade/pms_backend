package com.pms.management.services;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pms.management.constant.JunitConstants;
import com.pms.management.converter.UserConverter;
import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.EmailIdDto;
import com.pms.management.dto.IdAndNameDto;
import com.pms.management.dto.UserDetailsViewDto;
import com.pms.management.dto.UserDto;
import com.pms.management.dto.UserViewDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.repository.ManagementRepository;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.KeyCloakService;
import com.pms.management.utils.MailService;

@ExtendWith(MockitoExtension.class)
class MangamentServiceImplTest {

	@InjectMocks
	private MangamentServiceImpl service;

	@Mock
	private ManagementRepository repo;
 
	@Mock
	private UserConverter converter;

	@Mock
	private UserEntity entity;

	@Mock
	private UserDto userDto;

	@Mock
	private UserViewDto viewDto;

	@Mock
	private ChangePasswordDto changePasswordDto;

	@Mock
	private UserDetailsViewDto userDetailsViewDto;

	@Mock
	private IdAndNameDto idAndNameDto;

	@Mock
	private BCryptPasswordEncoder pwdEncoder;

	@Mock
	private MailService mailService;

	@Mock
	private KeyCloakService keyCloakService;

	@Mock
	EmailIdDto emailIdDto;
	@Test
	void testSaveUser() throws CustomException {
		when(userDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(null));
		when(userDto.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(converter.toEntity(userDto)).thenReturn(entity);
		when(pwdEncoder.encode(JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
	
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.saveUser(userDto));
	}

	@Test
	void testSaveUser_customException() throws CustomException {
		when(userDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.saveUser(userDto));
		assertEquals("Email id already exist", customException.getMessage());

	}

	@Test
	void testAddUser() throws CustomException {

		when(userDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(null));
		when(userDto.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(converter.toEntity(userDto)).thenReturn(entity);
		when(pwdEncoder.encode(JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.addUser(userDto));
	}

	@Test
	void testAddUser_customException() throws CustomException {
		when(userDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(entity));
		CustomException customException = assertThrows(CustomException.class, () -> service.addUser(userDto));
		assertEquals("Email id already exist", customException.getMessage());

	}

	@Test
	void testGetPatients() {
		List<UserEntity> entityList = new ArrayList<>();
		when(entity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getTitle()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getFirstName()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getLastName()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getDob()).thenReturn(JunitConstants.DATE_TYPE);
		when(entity.getRoleId()).thenReturn(JunitConstants.PATIENT_ROLE_TYPE);
		when(entity.getEmployeeId()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getContactNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		entityList.add(entity);
		when(repo.findAll()).thenReturn(entityList);
		
		assertNotNull(service.getPatients());
	}

	@Test
	void testGetHospitalUsers() {
		List<UserEntity> entityList = new ArrayList<>();
		when(entity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getTitle()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getFirstName()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getLastName()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getDob()).thenReturn(JunitConstants.DATE_TYPE);
		when(entity.getRoleId()).thenReturn(JunitConstants.PHYSICIAN_ROLE_TYPE);
		when(entity.getEmployeeId()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getContactNo()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		entityList.add(entity);
		when(repo.findAll()).thenReturn(entityList);
//		List<UserViewDto> list = new ArrayList<UserViewDto>();
//		list.add(viewDto);
		assertNotNull(service.getHospitalUsers());
	}

	@Test
	void testUpdateStatus_block() {
		when(userDto.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(userDto.getActive()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.updateStatus(userDto));

	}
	
	@Test
	void testUpdateStatus_inactive() {
		when(userDto.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(userDto.getActive()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(entity.getActiveStatus()).thenReturn(JunitConstants.IN_ACTICE_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.updateStatus(userDto));

	}
	
	@Test
	void testUpdateStatus_active() {
		when(userDto.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(userDto.getActive()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(entity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(entity.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.of(entity));
		when(pwdEncoder.encode(JunitConstants.DEFAULT_PASSWORD)).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		service.updateStatus(userDto);

	}

	@Test
	void testUpdateUserDetails() {
		when(userDto.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		when(repo.findByUserId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(userDto.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(userDto.getTitle()).thenReturn(JunitConstants.STRING_TYPE);
		when(userDto.getFirstName()).thenReturn(JunitConstants.STRING_TYPE);
		when(userDto.getLastName()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.updateUserDetails(userDto));
	}

	@Test
	void testFindByEmailId() throws CustomException {
		when(entity.getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.of(entity));
		when(converter.toDto(entity)).thenReturn((userDto));
		assertNotNull(service.findByEmailId(JunitConstants.STRING_TYPE));
	}

	@Test
	void testFindByEmailId_customeException() throws CustomException {
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.findByEmailId(JunitConstants.STRING_TYPE));
		assertEquals("Email id does not exist", customException.getMessage());
	}

	@Test
	void testUpdatePassword() throws CustomException {
		when(changePasswordDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.of(entity));
		when(changePasswordDto.getOldPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(changePasswordDto.getNewPassword()).thenReturn(JunitConstants.STRING_TYPE);
		when(pwdEncoder.matches(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.TRUE_TYPE);
		when(pwdEncoder.encode(JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.updatePassword(changePasswordDto));
	}

	@Test
	void testUpdatePassword_customException() throws CustomException {
		when(changePasswordDto.getEmailId()).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.updatePassword(changePasswordDto));
		assertEquals("Invalid email id", customException.getMessage());
	}
	
	@Test
	void testFindByUserId() throws CustomException {
		when(repo.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		assertNotNull(service.findByUserId(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testFindByUserId_customException()throws CustomException {
		when(repo.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		CustomException customException = assertThrows(CustomException.class,
				() -> service.findByUserId(JunitConstants.LONG_TYPE));
		assertEquals("User detail does not exits", customException.getMessage());
	}

	@Test
	void testMonthWiseData() {
		List<Object[]> list = new ArrayList<>();
		Object[] objArray = new Object[2];
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		list.add(objArray);
		when(repo.getMonthWiseRegistrationCount()).thenReturn(list);
		assertNotNull(service.monthWiseData());
	}
	
	@Test
	void testForgotPassword() throws CustomException {
		when(repo.findByEmailId(JunitConstants.STRING_TYPE)).thenReturn(Optional.of(entity));
		when(pwdEncoder.encode(JunitConstants.DEFAULT_PASSWORD)).thenReturn(JunitConstants.STRING_TYPE);
		when(repo.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(userDto);
		assertNotNull(service.forgotPassword(JunitConstants.STRING_TYPE));
	}
}
