package com.pms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.AllergyEntity;




@Repository
public interface AllergyRepo extends JpaRepository<AllergyEntity, Long>{
	
	AllergyEntity findByAllergyCode(String allergyCode);
	
	
}
