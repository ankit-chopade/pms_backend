package com.pms.visit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.PatientProcedureEntity;

@Repository
public interface PatientProcedureRepository extends JpaRepository<PatientProcedureEntity, Long> {

	@Query(value = " Select p.procedure_id , p.procedure_code , p.procedure_description , p.procedure_is_depricated, " +
			" patient_procedure.appointment_id , patient_procedure.created_date , " + 
			" patient_procedure.patient_procedure_id , patient_procedure.procedure_details " +
			" from pmsschema.procedures as p inner join ( select pp.appointment_id, pp.created_date, " +
			" pp.procedure_id, pp.procedure_details, pp.patient_procedure_id from pmsschema.patient_procedures pp inner join " +
			" ( select pa.appointment_id from pmsschema.patient_appointment pa where pa.patient_id = " +
			" ( select pa.patient_id from pmsschema.patient_appointment as pa where pa.appointment_id = :appointmentId ) ) " +
			" as appointment_id  on pp.appointment_id = appointment_id.appointment_id ) as patient_procedure " +
			" on p.procedure_id = patient_procedure.procedure_id order by patient_procedure.created_date desc", nativeQuery = true)

	public List<Object[]> findByAppointmentId(@Param("appointmentId") Long appointmentId);
}