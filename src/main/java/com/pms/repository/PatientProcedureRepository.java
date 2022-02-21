package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.entity.PatientProcedureEntity;

@Repository
public interface PatientProcedureRepository extends JpaRepository<PatientProcedureEntity, Long> {

	@Query(value = " Select p.procedure_id , p.procedure_code , p.procedure_description , p.procedure_is_depricated, "
			+ " pp.appointment_id ,  pp.created_date , pp.patient_procedure_id , pp.procedure_details  "
			+ " from pmsschema.patient_procedures as pp inner join  pmsschema.procedures as p "
			+ " on pp.procedure_id=p.procedure_id where pp.patient_id=  "
			+ "( SELECT patient_id FROM pmsschema.patientappointment as pa where pa.appointment_id = :appointmentId ) ", nativeQuery = true)

	public List<Object[]> findByAppointmentId(@Param("appointmentId") Long appointmentId);
}
