package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.PatientEntity;
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

}
