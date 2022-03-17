package com.pms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.AllergyEntity;




@Repository
public interface AllergyRepo extends JpaRepository<AllergyEntity, Long>{
	
	AllergyEntity findByAllergyCode(String allergyCode);
	
	List<AllergyEntity> findByAllergyIdIn(List<Long> id);
	
	
}
