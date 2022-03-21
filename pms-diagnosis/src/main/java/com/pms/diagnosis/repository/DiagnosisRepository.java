package com.pms.diagnosis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.diagnosis.entity.DiagnosisEntity;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Long> {

	List<DiagnosisEntity> findByActiveStatusOrderByCreatedDateDesc(Integer activeStatus);

	Optional<DiagnosisEntity> findByDiagnosisCodeAndActiveStatus(String diagnosisCode, Integer activeStatus);

	Optional<DiagnosisEntity> findByDiagnosisIdAndActiveStatus(Long diagnosisId, Integer activeStatus);
	
	List<DiagnosisEntity> findByActiveStatusAndDiagnosisIsDepricated(Integer activeStatus, Integer isDepricated);

}
