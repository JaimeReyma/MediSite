package com.backend.MediSite.Services;

import com.backend.MediSite.Models.EspecialidadModel;
import com.backend.MediSite.Repositories.IEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    IEspecialidad repo;


    public EspecialidadModel Create(EspecialidadModel Especialidad){
        if (Especialidad.getNombreEspecialidad() == null) {
            throw new IllegalArgumentException("No se permiten valores nulos en la columna 'NombreEspecialidad'.");
        }
        return repo.save(Especialidad);
    }

    public ArrayList<EspecialidadModel> Read(){
        return (ArrayList<EspecialidadModel>) repo.findAll();
    }

    public Optional<EspecialidadModel> EspecialidadById(Long IdEspecialidad){
        return repo.findById(IdEspecialidad);
    }

    public EspecialidadModel Update(EspecialidadModel request, Long IdEspecialidad) {
        Optional<EspecialidadModel> especialidadOptional = repo.findById(IdEspecialidad);
        if (!especialidadOptional.isPresent()) {
            throw new IllegalArgumentException("No se encuentra la especialidad con ese Id.");
        }

        EspecialidadModel especialidad = especialidadOptional.get();
        especialidad.setNombreEspecialidad(request.getNombreEspecialidad());

        return repo.save(especialidad);
    }

    public Boolean Delete (Long IdEspecialidad){
        try {
            repo.deleteById(IdEspecialidad);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
