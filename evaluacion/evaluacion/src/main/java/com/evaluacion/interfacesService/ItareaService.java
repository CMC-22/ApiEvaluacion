package com.evaluacion.interfacesService;

import java.util.List;
import java.util.Optional;

import com.evaluacion.model.tarea;

public interface ItareaService {
    public String save(tarea tarea);

    public List<tarea> findAll();

    public Optional<tarea> findById(String id);

    public int delete(String id);

}
