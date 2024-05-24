package com.backend.MediSite.Services;

import com.backend.MediSite.Models.CiudadModel;
import com.backend.MediSite.Models.UsuarioModel;
import com.backend.MediSite.Repositories.ICiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    ICiudad repo;


    public CiudadModel Create(CiudadModel Ciudad){
        if (Ciudad.getNombreCiudad() == null) {
            throw new IllegalArgumentException("No se permiten valores nulos en la columna 'NombreCiudad'.");
        }
        return repo.save(Ciudad);
    }

    public ArrayList<CiudadModel> Read(){
        return (ArrayList<CiudadModel>) repo.findAll();
    }

    public Optional<CiudadModel> CiudadById(Long IdCiudad){
        return repo.findById(IdCiudad);
    }

    public CiudadModel Update(CiudadModel request, Long IdCiudad) {
        Optional<CiudadModel> ciudadOptional = repo.findById(IdCiudad);
        if (!ciudadOptional.isPresent()) {
            throw new IllegalArgumentException("No se encuentra la ciudad con ese Id.");
        }

        CiudadModel ciudad = ciudadOptional.get();
        ciudad.setNombreCiudad(request.getNombreCiudad());

        return repo.save(ciudad);
    }

    public Boolean Delete (Long IdCiudad){
        try {
            repo.deleteById(IdCiudad);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
