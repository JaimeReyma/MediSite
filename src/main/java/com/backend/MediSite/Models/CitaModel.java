package com.backend.MediSite.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Cita")
public class CitaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCita")
    private Long idCita;

    @ManyToOne
    @JoinColumn(name = "IdMedico", nullable = false)
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "IdUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "IdEstatus", nullable = false)
    @JsonIgnore
    private EstatusModel estatus;

    @Column(name = "FechaHoraInicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "FechaHoraFin")
    private LocalDateTime fechaHoraFin;




    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public EstatusModel getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusModel estatus) {
        this.estatus = estatus;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
}
