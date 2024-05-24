package com.backend.MediSite.Services;

import com.backend.MediSite.Models.MedicoModel;
import com.backend.MediSite.Repositories.IMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    IMedico repo;


    public MedicoModel Create(MedicoModel Medico){
        if (Medico.getNombreMedico() == null || Medico.getCiudad() == null) {
            throw new IllegalArgumentException("No se permiten valores nulos en las columnas 'NombreMedico' y 'Ciudad'.");
        }
        return repo.save(Medico);
    }

    public ArrayList<MedicoModel> Read(){
        return (ArrayList<MedicoModel>) repo.findAll();
    }

    public Optional<MedicoModel> MedicoById(Long IdMedico){
        return repo.findById(IdMedico);
    }

    public MedicoModel Update(MedicoModel request, Long IdMedico) {
        Optional<MedicoModel> medicoOptional = repo.findById(IdMedico);
        if (!medicoOptional.isPresent()) {
            throw new IllegalArgumentException("No se encuentra el medico con ese Id.");
        }

        MedicoModel medico = medicoOptional.get();
        medico.setNombreMedico(request.getNombreMedico());
        medico.setCiudad(request.getCiudad());
        medico.setEspecialidad(request.getEspecialidad());


        return repo.save(medico);
    }

    public Boolean Delete (Long IdMedico){
        try {
            repo.deleteById(IdMedico);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
