package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alarm")
public class Alarm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne()
	private Soldadura soldadura;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Soldadura getSoldadura() {
		return soldadura;
	}

	public void setSoldadura(Soldadura soldadura) {
		this.soldadura = soldadura;
	}
	
}
