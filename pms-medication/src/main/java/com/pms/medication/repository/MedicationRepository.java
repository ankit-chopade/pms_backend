package com.pms.medication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.medication.entity.MedicationEntity;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {

	MedicationEntity findByDrugIdAndActiveStatus(String drugId, Integer status);

	MedicationEntity findByDrugNameAndActiveStatus(String drugId, Integer status);

}
