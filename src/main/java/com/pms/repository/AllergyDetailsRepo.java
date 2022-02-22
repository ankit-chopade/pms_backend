package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.AllergyEntity;

@Repository
public interface AllergyDetailsRepo extends JpaRepository<AllergyEntity, Integer>{
	AllergyEntity findByallergyType(String allergytype);
	AllergyEntity findByallergyName(String allergyName);
	AllergyEntity  findByAllergyCode(String allergyCode);
}
