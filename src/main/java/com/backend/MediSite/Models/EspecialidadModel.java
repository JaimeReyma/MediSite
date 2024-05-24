package com.backend.MediSite.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Especialidad")
public class EspecialidadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEspecialidad")
    private Long IdEspecialidad;

    @Column(name = "NombreEspecialidad", nullable = false)
    private String nombreEspecialidad;


    public Long getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        IdEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}
