package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends JpaRepository<UsuarioModel, Long> {



}
