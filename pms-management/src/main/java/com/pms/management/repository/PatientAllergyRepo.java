package com.pms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.PatientAllergyEntity;



@Repository
public interface PatientAllergyRepo extends JpaRepository<PatientAllergyEntity, Long> {

}
