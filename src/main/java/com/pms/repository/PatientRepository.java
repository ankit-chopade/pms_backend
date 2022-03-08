package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.DemographicDetail;
@Repository
public interface PatientRepository extends JpaRepository<DemographicDetail, Integer> {
	Optional<DemographicDetail> findByUserId(Integer id);
}
