package com.pms.visit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.visit.dto.IdAndDateDto;
import com.pms.visit.dto.PatientVisitHistoryViewDto;
import com.pms.visit.repository.VitalSignRepository;
import com.pms.visit.utils.PmsVisitUtil;

@Service
public class PatientVisitHistoryServiceImpl implements PatientVisitHistoryService {
	
	@Autowired
	private VitalSignRepository repository;

	@Override
	public List<PatientVisitHistoryViewDto> getAllVisitByDateAndId(IdAndDateDto dto) {
		List<Object[]> list = repository.findAllVisitByDateAndId(dto.getDate(),dto.getId());
		return list.stream().map(obj->
			 new PatientVisitHistoryViewDto(PmsVisitUtil.convertObjectIntoLong(obj[0]),
					PmsVisitUtil.convertObjectIntoString(obj[1]),PmsVisitUtil.convertObjectIntoString(obj[2]), PmsVisitUtil.convertObjectIntoString(obj[3]),PmsVisitUtil.convertObjectIntoString(obj[4]),
					PmsVisitUtil.convertObjectIntoLong(obj[5]),PmsVisitUtil.convertObjectIntoString(obj[6]))
		).collect(Collectors.toList());
	}
	
	
	
	
}
            
