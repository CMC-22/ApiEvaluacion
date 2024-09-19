package com.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.interfaces.Itarea;
import com.evaluacion.interfacesService.ItareaService;
import com.evaluacion.model.tarea;

@Service
public class tareaService implements ItareaService {

    @Autowired
    private Itarea data;

    @Override
    public String save(tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o vacío.");
        }

        if (tarea.getFechaVencimiento() == null) {
            throw new IllegalArgumentException("La fecha de vencimineto no puede ser nula.");
        }

        if (tarea.getCorreo() == null || tarea.getCorreo().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío.");
        }
        data.save(tarea);
        return "Usuario registrado con exito";
    }

    @Override
    public List<tarea> findAll() {
        return (List<tarea>) data.findAll();
    }

    @Override
    public Optional<tarea> findById(String id) {
        return data.findById(id);
    }

    @Override
	public int delete(String id) {
	    if (data.existsById(id)) {
	        data.deleteById(id);
	        return 1;
	    } else {
	        throw new IllegalArgumentException("Usuario no encontrado");
	    }
	}




}
