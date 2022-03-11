package com.pms.visit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.VitalSignEntity;
@Repository
public interface VitalSignRepository extends JpaRepository<VitalSignEntity, Long> {
	
	public Optional<VitalSignEntity> findByAppointmentId(Long id);
	
	
}
