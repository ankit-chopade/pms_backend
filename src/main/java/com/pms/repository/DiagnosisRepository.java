package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.DiagnosisEntity;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Long> {

	DiagnosisEntity findByDiagnosisCodeAndActiveStatus(String code, Integer status);

	List<DiagnosisEntity> findByDiagnosisDescriptionAndActiveStatus(String description, Integer status);
}
