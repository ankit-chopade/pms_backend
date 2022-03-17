package com.pms.visit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.visit.entity.PatientMedicationEntity;

@Repository
public interface PatientMedicationRepository extends JpaRepository<PatientMedicationEntity, Long> {

	@Query(value = "Select m.medication_id , m.drug_id , m.drug_name , patient_medication.drug_manufacturer_name , "
			+ " patient_medication.drug_generic_name , patient_medication.drug_form , "
			+ " patient_medication.drug_strength , patient_medication.appointment_id , "
			+ " patient_medication.created_date , patient_medication.patient_medication_id , patient_medication.medication_details "
			+ " from pmsschema.medications as m inner join ( select pm.drug_manufacturer_name , "
			+ " pm.drug_generic_name , pm.drug_form , pm.drug_strength , pm.appointment_id ,  "
			+ " pm.created_date , pm.patient_medication_id , pm.medication_details, pm.medication_id from pmsschema.patient_medications pm inner join "
			+ " ( select pa.appointment_id from pmsschema.patient_appointment pa where pa.patient_id = "
			+ " (select pa.patient_id from pmsschema.patient_appointment as pa where pa.appointment_id = :appointmentId  ) ) "
			+ " as appointment_id  on pm.appointment_id = appointment_id.appointment_id ) as patient_medication "
			+ " on m.medication_id = patient_medication.medication_id order by patient_medication.created_date desc" 
			, nativeQuery = true)
	public List<Object[]> findByAppointmentId(@Param("appointmentId") Long appointmentId);
	
	  
	
	  
	
	  
	
	 
	
	 
	 
	 
}
