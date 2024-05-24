package com.backend.MediSite.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "IdCiudad", nullable = false)
    private CiudadModel ciudad;

    @Column(name = "NombreUsuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Telefono")
    private String telefono;




    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
