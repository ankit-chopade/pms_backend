package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { 
	
	/**
	 * Find by first name and password.
	 *
	 * @param name the name
	 * @param password the password
	 * @return the optional
	 */
	public Optional<UserEntity> findByFirstNameAndPassword(String name,String password);

	
}
