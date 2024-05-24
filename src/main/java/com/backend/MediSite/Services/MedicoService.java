package com.backend.MediSite.Services;

import com.backend.MediSite.Models.CitaModel;
import com.backend.MediSite.Models.CiudadModel;
import com.backend.MediSite.Models.EspecialidadModel;
import com.backend.MediSite.Models.MedicoModel;
import com.backend.MediSite.Repositories.ICita;
import com.backend.MediSite.Repositories.IMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    IMedico repo;

    @Autowired
    private ICita citaRepository;


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

    public List<MedicoModel> ReadByIdEspecialidad(EspecialidadModel IdEspecialidad) {
        return repo.findByEspecialidad(IdEspecialidad);
    }

    public List<MedicoModel> ReadByIdCiudad(CiudadModel IdCiudad) {
        return repo.findByCiudad(IdCiudad);
    }


    public List<MedicoModel> ReadCiudadEspecialidad(EspecialidadModel especialidad, CiudadModel ciudad) {
        return repo.findByEspecialidadAndCiudad(especialidad, ciudad);
    }





    public List<MedicoModel> obtenerMedicosSinCitas(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        List<MedicoModel> todosLosMedicos = repo.findAll();
        List<MedicoModel> medicosConCitas = citaRepository.findMedicosConCitasEnRango(fechaHoraInicio, fechaHoraFin);
        todosLosMedicos.removeAll(medicosConCitas);
        return todosLosMedicos;
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
