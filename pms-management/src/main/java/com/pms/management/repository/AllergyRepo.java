package com.pms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.dto.AllergyDto;
import com.pms.management.entites.AllergyEntity;




@Repository
public interface AllergyRepo extends JpaRepository<AllergyEntity, Long>{
	
	public  AllergyEntity findByAllergyCode(String allergyCode);

	public List<AllergyEntity> findByActiveStatus(Integer activeStatus);
	List<AllergyEntity> findByAllergyIdIn(List<Long> id);
	
}
