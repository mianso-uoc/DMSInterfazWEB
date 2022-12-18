package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Pieza;

public interface PiezaRepository<T extends Pieza> extends JpaRepository<T, Long> {

}
