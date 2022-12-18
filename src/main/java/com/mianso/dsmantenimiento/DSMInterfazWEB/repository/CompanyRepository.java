package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Company;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.User;

public interface CompanyRepository<T extends Company> extends JpaRepository<T, Long> {

	List<User> findByName(String name);
	
}
