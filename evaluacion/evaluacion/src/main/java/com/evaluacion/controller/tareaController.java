package com.evaluacion.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.interfacesService.ItareaService;
import com.evaluacion.model.tarea;
import com.evaluacion.service.emailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/api/v1/tarea")
@RestController
@CrossOrigin
public class tareaController {
    @Autowired
    private ItareaService tareaService;

    @Autowired
    private emailService emailService;

    @PostMapping("/tasks")
    public ResponseEntity<Object> save(@RequestBody tarea tarea) {
        try {
            tareaService.save(tarea);
            //String resultadoCorreo = emailService.enviarCorreoConfirmacion(tarea);
            return ResponseEntity.ok("Usuario registrado con éxito. ");// + resultadoCorreo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al registrar la tarea");
        }
    }

    @GetMapping("/tasks")
	public ResponseEntity<Object>findAll(){
		var listaTarea = tareaService.findAll();
		return new ResponseEntity<>(listaTarea, HttpStatus.OK);
	}

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object>findOne(@PathVariable String id) {
        Optional<tarea> tarea = tareaService.findById(id);
        if (tarea.isPresent()) {
            return new ResponseEntity<>(tarea.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Tarea no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/eliminar/tasks/{id}")
    public ResponseEntity<Object>delete(@PathVariable String id) {
        try {
            tareaService.delete(id);
            return new ResponseEntity<>("Tarea elimnda con exito", HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object>update(@PathVariable String id, @RequestBody tarea tareaUpdate) {
        Optional<tarea> tareaOptional = tareaService.findById(id);
		if (tareaOptional.isPresent()) {
			tarea tarea = tareaOptional.get();
            tarea.setTitulo(tareaUpdate.getTitulo());
            tarea.setFechaVencimiento(tareaUpdate.getFechaVencimiento());
            tarea.setEstado(tareaUpdate.getEstado());
            tarea.setCorreo(tareaUpdate.getCorreo());
			tareaService.save(tarea);
			return new ResponseEntity<>(tarea,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error: tarea no encontrada",HttpStatus.BAD_REQUEST);
		}  
    }
}
