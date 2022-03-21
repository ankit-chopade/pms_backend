package com.pms.medication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.medication.entity.MedicationEntity;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {

	List<MedicationEntity> findByActiveStatusOrderByCreatedDateDesc(Integer activeStatus);

	Optional<MedicationEntity> findByDrugIdAndActiveStatus(String drugId, Integer activeStatus);

	Optional<MedicationEntity> findByMedicationIdAndActiveStatus(Long medicationId, Integer activeStatus);


}
