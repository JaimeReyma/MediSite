package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.CiudadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudad extends JpaRepository<CiudadModel, Long> {


}
