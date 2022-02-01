package com.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.AllergyDetailsEntity;

@Repository
public interface AllergyDetailsRepo extends JpaRepository<AllergyDetailsEntity, Integer>{
	AllergyDetailsEntity findByallergyType(String allergytype);
	AllergyDetailsEntity findByallergyName(String allergyName);
	Optional<List<AllergyDetailsEntity>> findallergyDetailsId(String allergyId);
}
