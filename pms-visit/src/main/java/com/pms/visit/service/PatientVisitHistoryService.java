package com.pms.visit.service;

import java.util.List;

import com.pms.visit.dto.IdAndDateDto;
import com.pms.visit.dto.PatientVisitHistoryViewDto;

public interface PatientVisitHistoryService {
	
	public List<PatientVisitHistoryViewDto> getAllVisitByDateAndId(IdAndDateDto dto);

}	
