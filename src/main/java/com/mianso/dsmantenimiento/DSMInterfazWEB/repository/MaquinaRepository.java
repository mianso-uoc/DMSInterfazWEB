package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Maquina;

public interface MaquinaRepository<T extends Maquina> extends JpaRepository<T, Long> {

}
