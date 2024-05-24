package com.backend.MediSite.Services;

import com.backend.MediSite.Models.EstatusModel;
import com.backend.MediSite.Repositories.IEstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstatusService {

    @Autowired
    IEstatus repo;


    public EstatusModel Create(EstatusModel Estatus){
        if (Estatus.getNombreEstatus() == null) {
            throw new IllegalArgumentException("No se permiten valores nulos en la columna 'NombreEstatus'.");
        }
        return repo.save(Estatus);
    }

    public ArrayList<EstatusModel> Read(){
        return (ArrayList<EstatusModel>) repo.findAll();
    }

    public Optional<EstatusModel> EstatusById(Long IdEstatus){
        return repo.findById(IdEstatus);
    }

    public EstatusModel Update(EstatusModel request, Long IdEstatus) {
        Optional<EstatusModel> estatusOptional = repo.findById(IdEstatus);
        if (!estatusOptional.isPresent()) {
            throw new IllegalArgumentException("No se encuentra la estatus con ese Id.");
        }

        EstatusModel estatus = estatusOptional.get();
        estatus.setNombreEstatus(request.getNombreEstatus());

        return repo.save(estatus);
    }

    public Boolean Delete (Long IdEstatus){
        try {
            repo.deleteById(IdEstatus);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
