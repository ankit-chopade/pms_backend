package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.AllergyIdEntity;

@Repository
public interface AllergyIdRepo extends JpaRepository<AllergyIdEntity, Integer> {

}
