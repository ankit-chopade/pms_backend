package com.pms.procedure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.procedure.entity.ProcedureEntity;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
	
	public List<ProcedureEntity> findByActiveStatusOrderByCreatedDateDesc(Integer activeStatus);

	public Optional<ProcedureEntity> findByProcedureCodeAndActiveStatus(String procedureCode, Integer status);
	
	public Optional<ProcedureEntity> findByProcedureIdAndActiveStatus(Long id, Integer status);

	List<ProcedureEntity> findByActiveStatusAndProcedureIsDepricated(Integer activeStatus, Integer isDepricated);
}
