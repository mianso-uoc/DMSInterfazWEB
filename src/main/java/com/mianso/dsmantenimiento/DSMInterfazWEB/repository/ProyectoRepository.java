package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Proyecto;

public interface ProyectoRepository<T extends Proyecto> extends JpaRepository<T, Long> {

}
