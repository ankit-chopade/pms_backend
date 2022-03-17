package com.pms.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.schedule.entity.PatientAppointmentEntity;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointmentEntity, Long> {
	
	public List<PatientAppointmentEntity> findByPhysicianId(Long Id);

	public PatientAppointmentEntity findByAppointmentId(Long Id);

	public Long deleteByAppointmentId(Long Id);

	public List<PatientAppointmentEntity> findByPatientId(Long Id);
	

}
