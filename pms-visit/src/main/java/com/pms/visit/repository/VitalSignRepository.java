package com.pms.visit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.VitalSignEntity;
@Repository
public interface VitalSignRepository extends JpaRepository<VitalSignEntity, Long> {
	
	public Optional<VitalSignEntity> findByAppointmentId(Long id);
	
	@Query(value=" select v.blood_pressure from pmsschema.vital_signs v where v.appointment_id in ( "
			+ " select a.appointment_id from pmsschema.patientappointment a where "
			+ " a.patient_id = :patientId order by a.start_time desc LIMIT 5) ", nativeQuery = true)
	public List<String> findBloodPressureByPatientId(@Param("patientId") Long patientId);
	
	@Query(value=" select v.respiration_rate from pmsschema.vital_signs v where v.appointment_id in ( "
			+ " select a.appointment_id from pmsschema.patientappointment a where "
			+ " a.patient_id = :patientId order by a.start_time desc LIMIT 5) ", nativeQuery = true)
	public List<String> findRespirationRateByPatientId(@Param("patientId") Long patientId);
	
	@Query(value="select v.height, v.respiration_rate, v.weight, v.body_temperature from pmsschema.vital_signs v "
			+ " where v.appointment_id = ( "
			+ " select a.appointment_id from pmsschema.patientappointment a where a.patient_id = :patientId "
			+ " order by a.start_time desc LIMIT 1 ) ", nativeQuery = true)
	public String findLatestVitalSignsByPatientId(@Param("patientId") Long patientId);
	
	
}
