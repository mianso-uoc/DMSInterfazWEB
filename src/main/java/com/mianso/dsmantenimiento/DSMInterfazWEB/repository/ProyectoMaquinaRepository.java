package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Proyecto;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.ProyectoMaquina;

public interface ProyectoMaquinaRepository<T extends ProyectoMaquina> extends JpaRepository<T, Long> {

}
