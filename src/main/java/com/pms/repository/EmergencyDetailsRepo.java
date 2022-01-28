package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.EmergencyContactEntity;
import com.pms.entity.MenuEntity;

@Repository
public interface EmergencyDetailsRepo extends JpaRepository<EmergencyContactEntity, Integer>{

}
