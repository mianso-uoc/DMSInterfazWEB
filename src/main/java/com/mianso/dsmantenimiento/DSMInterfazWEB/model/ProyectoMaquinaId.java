package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class ProyectoMaquinaId implements Serializable {

	private static final long serialVersionUID = 1L;
	private long proyecto;
	private long maquina;

	public ProyectoMaquinaId() {}

	public ProyectoMaquinaId(long proyecto, long maquina) {
		this.proyecto = proyecto;
		this.maquina = maquina;
	}

	public long getProyecto() {
		return proyecto;
	}

	public void setProyecto(long proyecto) {
		this.proyecto = proyecto;
	}

	public long getMaquina() {
		return maquina;
	}

	public void setMaquina(long maquina) {
		this.maquina = maquina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maquina, proyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoMaquinaId other = (ProyectoMaquinaId) obj;
		return maquina == other.maquina && proyecto == other.proyecto;
	}

}
