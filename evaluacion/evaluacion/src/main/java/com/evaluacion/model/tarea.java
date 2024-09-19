package com.evaluacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name="tarea")
public class tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "fechaVencimiento", nullable = false)
    private Date fechaVencimiento;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Enumerated(EnumType.STRING) 
    @Column(name = "estado", nullable = false, length = 50)
    private estado estado;

    public tarea() {
    }

    public tarea(String id, String titulo, Date fechaVencimiento, String correo, com.evaluacion.model.estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.fechaVencimiento = fechaVencimiento;
        this.correo = correo;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public estado getEstado() {
        return estado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }
    
}

