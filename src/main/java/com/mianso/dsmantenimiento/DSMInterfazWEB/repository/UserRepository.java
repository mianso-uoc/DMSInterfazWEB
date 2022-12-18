package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
	
	List<User> findByType(String type);
	
	User findByEmail(String email);
	
	Boolean existsByEmail(String email);
	
}
