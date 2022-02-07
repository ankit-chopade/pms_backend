package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.ProcedureEntity;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
	
}
