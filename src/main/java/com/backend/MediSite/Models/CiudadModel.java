package com.backend.MediSite.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Ciudad")
public class CiudadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCiudad")
    private Long idCiudad;

    @Column(name = "NombreCiudad", nullable = false)
    private String nombreCiudad;




    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
