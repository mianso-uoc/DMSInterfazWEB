package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "pieza")
public class Pieza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private ProyectoMaquina proyectoMaquina;

	@OneToMany(mappedBy = "pieza", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(clause = "DATE ASC")
	private List<Soldadura> soldaduras;

	public Pieza() {
	}

	public Pieza(String name, String address, Float latitude, Float longitude, String phone) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProyectoMaquina getProyectoMaquina() {
		return proyectoMaquina;
	}

	public void setProyectoMaquina(ProyectoMaquina proyectoMaquina) {
		this.proyectoMaquina = proyectoMaquina;
	}

	public List<Soldadura> getSoldaduras() {
		return soldaduras;
	}

	public void setSoldaduras(List<Soldadura> soldaduras) {
		this.soldaduras = soldaduras;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
