package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Employee extends User {
	
	@ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

	public Employee() {
		super();
	}
	
	public Employee(String email, String name, String password) {
		super(email, name, password);
	}

	public Employee(long id, String email, String name, String password) {
		super(id, email, name, password);
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
