package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "proyecto_maquina")
@IdClass(ProyectoMaquinaId.class)
public class ProyectoMaquina {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id")
    private Proyecto proyecto;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "maquina_id", referencedColumnName = "id")
    private Maquina maquina;
	
	@OneToMany(mappedBy = "proyectoMaquina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pieza> piezas;
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}

}
