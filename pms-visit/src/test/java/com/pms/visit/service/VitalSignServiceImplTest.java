package com.pms.visit.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.visit.constants.JunitConstants;
import com.pms.visit.converter.VitalSignConverter;
import com.pms.visit.dto.DashboardVitalDto;
import com.pms.visit.dto.VitalSignDto;
import com.pms.visit.entity.VitalSignEntity;
import com.pms.visit.repository.VitalSignRepository;

@ExtendWith(MockitoExtension.class)
class VitalSignServiceImplTest {
	
	@InjectMocks
	private VitalSignServiceImpl service;
	
	@Mock
	private VitalSignRepository repository;
	
	@Mock
	private VitalSignConverter converter;
	
	@Mock
	private VitalSignEntity entity;
	
	@Mock
	private VitalSignDto vitaldto;
	
	@Mock
	private DashboardVitalDto dashboardDto;

	@Test
	void testGetDetailByAppointmentId() {
		when(repository.findByAppointmentId(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(converter.toDto(entity)).thenReturn(vitaldto);
		assertNotNull(service.getDetailByAppointmentId(JunitConstants.LONG_TYPE));
		when(repository.findByAppointmentId(JunitConstants.LONG_TYPE)).thenReturn(Optional.ofNullable(null));
		assertNull(service.getDetailByAppointmentId(JunitConstants.LONG_TYPE));
	}

	@Test
	void testSaveVitalSigns() {
		when(converter.toEntity(vitaldto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDto(entity)).thenReturn(vitaldto);
		assertNotNull(service.saveVitalSigns(vitaldto));
	}

	@Test
	void testGetBloodPressure() {
		when(repository.findBloodPressureByPatientId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LIST_STRING_TYPE);
		assertNotNull(service.getBloodPressure(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetRespirationRate() {
		when(repository.findRespirationRateByPatientId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.LIST_STRING_TYPE);
		assertNotNull(service.getRespirationRate(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetLatestVitalSigns() {
		when(repository.findLatestVitalSignsByPatientId(JunitConstants.LONG_TYPE)).thenReturn(JunitConstants.DASHBOARD_STRING_TYPE);
		assertNotNull(service.getLatestVitalSigns(JunitConstants.LONG_TYPE));
	}

}
