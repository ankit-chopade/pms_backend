package com.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.AllergyDetailsEntity;

@Repository
public interface AllergyDetailsRepo extends JpaRepository<AllergyDetailsEntity, String>{
	AllergyDetailsEntity findByallergyType(String allergytype);
	AllergyDetailsEntity findByallergyName(String allergyName);
	AllergyDetailsEntity findByAllergyDetailsId(String string);
}
