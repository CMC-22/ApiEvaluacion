package com.evaluacion.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.model.tarea;

@Repository
public interface Itarea extends CrudRepository<tarea, String> {

}
