package com.pms.management.services;

import java.util.List;
import java.util.Optional;

import com.pms.management.dto.AllergyDto;


public interface AllergyService {

	AllergyDto save(AllergyDto dto);

	Optional<AllergyDto> getAllergybyId(Long allergyId);

	List<AllergyDto> getAllergyDetails();

	AllergyDto getbyAllergyCode(String allergyCode);

	List<AllergyDto> getByAllergyIdIn(List<Long> id);
}