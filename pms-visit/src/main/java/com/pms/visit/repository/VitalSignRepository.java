package com.pms.visit.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.VitalSignEntity;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSignEntity, Long> {

	public Optional<VitalSignEntity> findByAppointmentId(Long id);

	@Query(value = "SELECT pa.appointment_id, pa.subject, pa.description, pa.start_time, pa.end_time, pa.patient_id, "
			+ " u.first_name || ' ' || u.last_name as physician_name " + " FROM pmsschema.patient_appointment pa "
			+ " INNER JOIN pmsschema.users u " + " ON pa.physician_id=u.user_id "
			+ " WHERE date(pa.start_time)  < date(:customDate)  and pa.patient_id = :patientId "
			+ "", nativeQuery = true)
	public List<Object[]> findAllVisitByDateAndId(Date customDate, Long patientId);

}
