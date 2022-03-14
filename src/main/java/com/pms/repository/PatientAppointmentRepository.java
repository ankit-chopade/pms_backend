package com.pms.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pms.entity.PatientAppointmentEntity;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointmentEntity, Long>{
	public List<PatientAppointmentEntity> findByPhysicianId(Long Id);
	public PatientAppointmentEntity findByAppointmentId(Long Id);
	public Long deleteByAppointmentId(Long Id);
	public List<PatientAppointmentEntity> findByPatientId(Long Id);
	
	
	
	
	//By AbhijeetR
	@Query("select a.appointmentId, a.subject, a.description, a.startTime  from PatientAppointmentEntity a where a.physicianId = ?1 And a.appointmentDate BETWEEN ?2 AND ?3 ")
	List<Object[]> getAppointmentToPhysician(Long physicianId, LocalDate startDate, LocalDate endDate);

	@Query("select a.appointmentId, a.subject, a.description, a.startTime from PatientAppointmentEntity a where a.patientId = ?1 And a.appointmentDate BETWEEN ?2 AND ?3")
	List<Object[]> getAppointmentToPatient(Long patientId, LocalDate startDate, LocalDate endDate);
	
	@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as physician_name " +
	"from pmsschema.patientappointment a inner join pmsschema.users u	on a.physician_id=u.user_id	where  " +
			"date(a.start_time)= date(:customDate)",nativeQuery=true)
	public List<Object[]> getAppointmentsByDate( Date customDate);
	
	

//	@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as physician_name " +
//	"from pmsschema.patientappointment a inner join pmsschema.users u	on a.physician_id=u.user_id	where  " +
//			"date(a.start_time)= date(:customDate)",nativeQuery=true)
//	public List<Object[]> getAppointmentsByDateToNurse(Date date);
	
	
//	
	@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as physician_name " +
			"from pmsschema.patientappointment a inner join pmsschema.users u	on a.patient_id=u.user_id	where  " +
					"date(a.start_time)= date(:customDate) and a.patient_id = :patientId ",nativeQuery=true)
			public List<Object[]> getAppointmentsByDateAndPatientId( Date customDate, Long patientId);
			
			
	@Query(value="select a.appointment_id, a.subject, a.description, a.start_time, a.patient_id, concat(u.first_name,' ',u.last_name) as physician_name " +
		    "from pmsschema.patientappointment a inner join pmsschema.users u	on a.physician_id=u.user_id	where  " +
			"date(a.start_time)= date(:customDate) and a.physician_id = :physicianId ",nativeQuery=true)
      public List<Object[]> getAppointmentsByDateAndPhysicianId( Date customDate, Long physicianId);
	
	
}
