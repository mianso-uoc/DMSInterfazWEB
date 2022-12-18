package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyecto> projects;

	public Manager() {
		super();
	}
	
	public Manager(String email, String name, String password) {
		super(email, name, password);
	}

	public Manager(long id, String email, String name, String password) {
		super(id, email, name, password);
	}

	public List<Proyecto> getProjects() {
		return projects;
	}

	public void setProjects(List<Proyecto> projects) {
		this.projects = projects;
	}
	
}
