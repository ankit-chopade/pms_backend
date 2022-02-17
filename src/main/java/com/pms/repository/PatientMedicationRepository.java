package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.entity.PatientMedicationEntity;

@Repository
public interface PatientMedicationRepository extends JpaRepository<PatientMedicationEntity, Long> {

	@Query(value = " Select m.medication_id , m.drug_id , m.drug_name , pm.drug_manufacturer_name ,  m.drug_generic_name , pm.drug_form ,"
			+ " pm.drug_strength , pm.appointment_id ,  pm.created_date , pm.patient_medication_id , pm.medication_details "
			+ " from pmsschema.patient_medications as pm "
			+ " inner join  pmsschema.medications as m on pm.medication_id=m.medication_id where pm.patient_id=  "  
			+ " ( SELECT patient_id FROM pmsschema.patientappointment as pa where pa.appointment_id = :appointmentId ) " 
			, nativeQuery = true)
	public List<Object[]> findByAppointmentId(@Param("appointmentId") Long appointmentId);
}
