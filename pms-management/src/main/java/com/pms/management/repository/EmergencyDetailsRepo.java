package com.pms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.EmergencyContactEntity;



@Repository
public interface EmergencyDetailsRepo extends JpaRepository<EmergencyContactEntity, Long>{

}
