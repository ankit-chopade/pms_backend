package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { 



	
	public Optional<UserEntity> findByUserId(Integer id);
	

	public Optional<UserEntity> findByEmailId(String emailId);
	

}
