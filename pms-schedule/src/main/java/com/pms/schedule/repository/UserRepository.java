package com.pms.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.schedule.entity.UserEntity;


/**
 * The Interface UserRepository.
 */
@Repository
	
public interface UserRepository extends JpaRepository<UserEntity, Long> { 

	public Optional<UserEntity> findByUserId(Long id);
	
	public Optional<UserEntity> findByEmailId(String emailId);
	
	public List<UserEntity> findByRoleId(Integer roleId);
	public Optional<UserEntity> findByEmailIdAndPassword(String emailId,String password);

}
