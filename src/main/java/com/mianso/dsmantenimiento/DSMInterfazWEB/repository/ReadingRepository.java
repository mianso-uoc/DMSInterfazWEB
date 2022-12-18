package com.mianso.dsmantenimiento.DSMInterfazWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Reading;

public interface ReadingRepository<T extends Reading> extends JpaRepository<T, Long> {

}
