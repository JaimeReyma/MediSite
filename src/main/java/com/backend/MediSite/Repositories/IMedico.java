package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.CiudadModel;
import com.backend.MediSite.Models.MedicoModel;
import com.backend.MediSite.Models.EspecialidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IMedico extends JpaRepository<MedicoModel, Long> {

    List<MedicoModel> findByEspecialidad(EspecialidadModel IdEspecialidad);

    List<MedicoModel> findByCiudad(CiudadModel IdCiudad);

    List<MedicoModel> findByEspecialidadAndCiudad(EspecialidadModel especialidad, CiudadModel ciudad);




}
