package com.pms.allergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.allergy.entity.AllergyEntity;


@Repository
public interface AllergyRepo extends JpaRepository<AllergyEntity, Long>{
	
	AllergyEntity findByAllergyCode(String allergyCode);
}
