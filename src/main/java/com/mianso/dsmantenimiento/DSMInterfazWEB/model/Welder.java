package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import javax.persistence.Entity;

@Entity
public class Welder extends Employee {

	public Welder() {
		super();
	}
	
	public Welder(String email, String name, String password) {
		super(email, name, password);
	}

	public Welder(long id, String email, String name, String password) {
		super(id, email, name, password);
	}
	
}
