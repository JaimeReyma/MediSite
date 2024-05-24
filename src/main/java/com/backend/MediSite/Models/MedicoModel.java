package com.backend.MediSite.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMedico")
    private Long IdMedico;

    @ManyToOne
    @JoinColumn(name = "IdCiudad", nullable = false)
    private CiudadModel ciudad;

    @ManyToOne
    @JoinColumn(name = "IdEspecialidad", nullable = false)
    private EspecialidadModel especialidad;

    @Column(name = "NombreMedico", nullable = false)
    private String nombreMedico;




    public Long getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(Long idMedico) {
        IdMedico = idMedico;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public EspecialidadModel getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
}
