package com.backend.MediSite.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Estatus")
public class EstatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEstatus")
    private Long IdEstatus;

    @Column(name = "NombreEstatus", nullable = false)
    private String nombreEstatus;




    public Long getIdEstatus() {
        return IdEstatus;
    }

    public void setIdEstatus(Long idEstatus) {
        IdEstatus = idEstatus;
    }

    public String getNombreEstatus() {
        return nombreEstatus;
    }

    public void setNombreEstatus(String nombreEstatus) {
        this.nombreEstatus = nombreEstatus;
    }
}
