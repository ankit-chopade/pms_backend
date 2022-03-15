package com.pms.visit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.PatientDiagnosisEntity;

@Repository
public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosisEntity, Long> {

	@Query
	(value= " select d.diagnosis_id, d.diagnosis_code,d.diagnosis_description,d.diagnosis_is_depricated , " + 
		    " patient_diagnosis.appointment_id , patient_diagnosis.created_date , " + 
		    " patient_diagnosis.patient_diagnosis_id , patient_diagnosis.diagnosis_details " +
		    " from pmsschema.diagnosis as d inner join ( select pd.appointment_id, pd.created_date, " +
		    " pd.diagnosis_id, pd.diagnosis_details, pd.patient_diagnosis_id from pmsschema.patient_diagnosis pd inner join " +
			" ( select pa.appointment_id from pmsschema.patient_appointment pa where pa.patient_id = " +
			" ( select pa.patient_id from pmsschema.patient_appointment as pa where pa.appointment_id = :appointmentId ) ) " +
			" as appointment_id  on pd.appointment_id = appointment_id.appointment_id ) as patient_diagnosis " +
			" on d.diagnosis_id = patient_diagnosis.diagnosis_id order by patient_diagnosis.created_date desc" 
			,nativeQuery = true)
	
	public  List<Object[]> findByAppointmentId(@Param("appointmentId") Long appointmentId);
	

}
