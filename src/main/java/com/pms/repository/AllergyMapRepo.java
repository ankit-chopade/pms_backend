package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.AllergyMapEntity;

@Repository
public interface AllergyMapRepo extends JpaRepository<AllergyMapEntity, Integer> {

}
