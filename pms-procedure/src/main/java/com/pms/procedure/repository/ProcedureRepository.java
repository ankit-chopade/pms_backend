package com.pms.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.procedure.entity.ProcedureEntity;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
	
}
