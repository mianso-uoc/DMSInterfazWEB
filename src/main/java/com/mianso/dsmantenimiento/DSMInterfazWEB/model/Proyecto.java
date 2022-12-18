package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@ManyToOne()
    @JoinColumn(name = "manager_id")
	private Manager manager;
	
	@OneToMany(mappedBy = "proyecto")
    private List<ProyectoMaquina> maquinasProyecto;

	public Proyecto() {}
	
	public Proyecto(String name, String description, Manager manager) {
		super();
		this.name = name;
		this.description = description;
		this.manager = manager;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", manager=" + manager + "]";
	}

}
