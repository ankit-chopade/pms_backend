package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { 

	public Optional<UserEntity> findByUserId(Long id);
	
	public Optional<UserEntity> findByEmailId(String emailId);
	

}
