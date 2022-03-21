package com.pms.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.management.entites.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

	public Optional<List<MenuEntity>> findByRoleIdOrderByMenuId(Integer roleId);
	
}
