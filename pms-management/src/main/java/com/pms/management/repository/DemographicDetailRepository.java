package com.pms.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.DemographicDetailEntity;

@Repository
public interface DemographicDetailRepository extends JpaRepository<DemographicDetailEntity, Long> {
	Optional<DemographicDetailEntity> findByUserId(Long id);
}
