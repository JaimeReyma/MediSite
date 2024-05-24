package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.CitaModel;
import com.backend.MediSite.Models.MedicoModel;
import com.backend.MediSite.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICita extends JpaRepository<CitaModel, Long> {

    boolean existsCitaByUsuarioAndFechaHoraInicioBetween(UsuarioModel usuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin);

    boolean existsCitaByMedicoAndFechaHoraInicioBetween(MedicoModel medico, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin);

    List<CitaModel> findByUsuarioAndFechaHoraInicioBetween(UsuarioModel usuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin);
}
