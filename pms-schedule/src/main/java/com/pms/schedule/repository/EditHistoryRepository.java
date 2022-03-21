package com.pms.schedule.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.schedule.entity.EditHistoryEntity;
@Repository
public interface EditHistoryRepository extends JpaRepository<EditHistoryEntity, Long>{
	List<EditHistoryEntity> findByHistoryId(Long id);
	List<EditHistoryEntity> findByPatientId(Long id);
	
}

