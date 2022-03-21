package com.pms.schedule.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.schedule.entity.PatientAppointmentEntity;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointmentEntity, Long> {
	
	public List<PatientAppointmentEntity> findByPhysicianId(Long id);

	public PatientAppointmentEntity findByAppointmentId(Long id);

	public Long deleteByAppointmentId(Long id);

	public List<PatientAppointmentEntity> findByPatientId(Long id);
	
	// Inbox Methods
		@Query(value="select pau.appointment_id, pau.subject, pau.description, pau.start_time, pau.patient_id, concat(pau.first_name,' ',pau.last_name) as physician_name, concat(u.first_name,' ',u.last_name) as patient_name " +
		"from pmsschema.users u inner join (select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, u.first_name,u.last_name " +
		"from pmsschema.patient_appointment a inner join pmsschema.users u on a.physician_id=u.user_id where " +
		"date(a.start_time)= date(:customDate)) pau on pau.patient_id=u.user_id ",nativeQuery=true)
		public List<Object[]> getAppointmentsByDate( Date customDate);


		@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as physician_name " +
		"from pmsschema.patient_appointment a inner join pmsschema.users u on a.physician_id=u.user_id where " +
		"date(a.start_time)= date(:customDate) and a.patient_id = :patientId ",nativeQuery=true)
		public List<Object[]> getAppointmentsByDateAndPatientId( Date customDate, Long patientId);


		@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as patient_name " +
		"from pmsschema.patient_appointment a inner join pmsschema.users u on a.patient_id=u.user_id where " +
		"date(a.start_time)= date(:customDate) and a.physician_id = :physicianId ",nativeQuery=true)
		public List<Object[]> getAppointmentsByDateAndPhysicianId( Date customDate, Long physicianId);
}
