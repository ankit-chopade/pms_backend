package com.pms.visit.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.visit.constants.JunitConstants;
import com.pms.visit.dto.IdAndDateDto;
import com.pms.visit.dto.PatientVisitHistoryViewDto;
import com.pms.visit.repository.VitalSignRepository;

@ExtendWith(MockitoExtension.class)
class PatientVisitHistoryServiceImplTest {

	@InjectMocks
	private PatientVisitHistoryServiceImpl service;
	
	@Mock
	private VitalSignRepository repository;
	
	@Mock
	private PatientVisitHistoryViewDto dto;
	
	@Mock
	private IdAndDateDto idDateDto;
	
	@Test
	void test() {
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] objArray = new Object[7];
		
		objArray[0] = JunitConstants.LONG_TYPE;
		objArray[1] = JunitConstants.STRING_TYPE;
		objArray[2] = JunitConstants.STRING_TYPE;
		objArray[3] = JunitConstants.STRING_TYPE;
		objArray[4] = JunitConstants.STRING_TYPE;
		objArray[5] = JunitConstants.LONG_TYPE;
		objArray[6] = JunitConstants.STRING_TYPE;
		
		list.add(objArray);
		when(repository.findAllVisitByDateAndId(null, JunitConstants.ZERO_LONG_TYPE)).thenReturn(list);
		assertNotNull(service.getAllVisitByDateAndId(idDateDto));
	}

}
