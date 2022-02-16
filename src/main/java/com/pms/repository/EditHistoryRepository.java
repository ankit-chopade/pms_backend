package com.pms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.EditHistoryEntity;
@Repository
public interface EditHistoryRepository extends JpaRepository<EditHistoryEntity, Long>{
	List<EditHistoryEntity> findByHistoryId(Long Id);
	List<EditHistoryEntity> findByPatientId(Long Id);
	
}

