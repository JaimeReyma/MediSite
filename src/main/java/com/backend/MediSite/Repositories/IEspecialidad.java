package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.EspecialidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidad extends JpaRepository<EspecialidadModel, Long> {


}
