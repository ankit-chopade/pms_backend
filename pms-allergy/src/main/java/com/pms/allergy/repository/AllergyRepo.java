package com.pms.allergy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.allergy.entity.AllergyEntity;


@Repository
public interface AllergyRepo extends JpaRepository<AllergyEntity, Long>{
	
	AllergyEntity findByAllergyCode(String allergyCode);
	
	List<AllergyEntity> findByActiveStatusOrderByCreatedDateDesc(Integer activeStatus);

	Optional<AllergyEntity> findByAllergyCodeAndActiveStatus(String allergyCode, Integer status);
	
	Optional<AllergyEntity> findByAllergyIdAndActiveStatus(Long id, Integer status);
}
