package com.backend.MediSite.Repositories;

import com.backend.MediSite.Models.EstatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstatus extends JpaRepository<EstatusModel, Long> {



}
