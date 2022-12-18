package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "maquina")
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String serialNumber;
	
	@ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;
	
	@OneToMany(mappedBy = "maquina")
    private List<ProyectoMaquina> proyectosMaquina;
	
	public Maquina() {	}

	public Maquina(String serialNumber, Company company) {
		super();
		this.serialNumber = serialNumber;
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<ProyectoMaquina> getProyectosMaquina() {
		return proyectosMaquina;
	}

	public void setProyectosMaquina(List<ProyectoMaquina> proyectosMaquina) {
		this.proyectosMaquina = proyectosMaquina;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", serialNumber=" + serialNumber + ", company=" + company + "]";
	}
	
}
