package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedico extends JpaRepository<MedicoModel, Long> {



}
