package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.PatientBasicDetail;
@Repository
public interface PatientRepository extends JpaRepository<PatientBasicDetail, Integer> {
	Optional<PatientBasicDetail> findByUserId(Integer id);
}