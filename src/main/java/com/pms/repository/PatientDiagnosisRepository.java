package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.entity.PatientDiagnosisEntity;

@Repository
public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosisEntity, Long> {
	
	@Query
	(value="Select d.diagnosis_id, d.diagnosis_code,d.diagnosis_description,d.diagnosis_is_depricated from pmsschema.patient_diagnosis as pd " + 
	"inner join  pmsschema.diagnosis as d on pd.diagnosis_id=d.diagnosis_id " + 
			"	where pd.patient_id= " + 
			"	(SELECT patient_id	FROM pmsschema.patientappointment as pa where pa.appointment_id = :appointmentId ) " 
			,nativeQuery = true)
	
	public  List<Object[]> findDiagnosisByAppointmentId(@Param("appointmentId") Long appointmentId);
	
}
