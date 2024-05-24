package com.backend.MediSite.Services;

import com.backend.MediSite.Models.*;
import com.backend.MediSite.Repositories.ICita;
import com.backend.MediSite.Repositories.IEstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CitaService {

    @Autowired
    private ICita repo;

    @Autowired
    private IEstatus estatusRepository;

    public CitaModel Create(CitaModel cita) {

        if (cita.getMedico() == null || cita.getUsuario() == null || cita.getFechaHoraInicio() == null || cita.getFechaHoraFin() == null) {
            throw new IllegalArgumentException("Los campos de 'medico', 'usuario', 'fechaHoraInicio' y 'fechaHoraFin' no pueden ser nulos. Revise su petición.");
        }

        if (cita.getFechaHoraInicio().isAfter(cita.getFechaHoraFin())) {
            throw new IllegalArgumentException("La fecha y hora de inicio de la cita debe ser anterior a la fecha y hora del fin de la cita por programar.");
        }

        boolean medicoTieneCita = repo.existsCitaByMedicoAndFechaHoraInicioBetween(cita.getMedico(), cita.getFechaHoraInicio(), cita.getFechaHoraFin());
        if (medicoTieneCita) {
            throw new IllegalArgumentException("El médico ya tiene una cita programada en el mismo rango de horario.");
        }

        boolean usuarioTieneCita = repo.existsCitaByUsuarioAndFechaHoraInicioBetween(cita.getUsuario(), cita.getFechaHoraInicio(), cita.getFechaHoraFin());
        if (usuarioTieneCita) {
            throw new IllegalArgumentException("El usuario ya tiene una cita programada en el mismo rango de horario.");
        }

        EstatusModel estatus = estatusRepository.getById(1L);
        cita.setEstatus(estatus);

        return repo.save(cita);
    }


    public Optional<CitaModel> CitaById(Long IdCita){
        return repo.findById(IdCita);
    }




    public CitaModel actualizarCita(Long idCita, LocalDateTime nuevaFechaHoraInicio, LocalDateTime nuevaFechaHoraFin) {
        Optional<CitaModel> citaOptional = repo.findById(idCita);
        CitaModel citaExistente = citaOptional.orElseThrow(() -> new NoSuchElementException("No se encontró la cita con el ID proporcionado."));

        if (nuevaFechaHoraInicio.isAfter(nuevaFechaHoraFin)) {
            throw new IllegalArgumentException("La nueva fecha y hora de inicio de la cita debe ser anterior a la nueva fecha y hora del fin de la cita.");
        }

        boolean medicoTieneCita = repo.existsCitaByMedicoAndFechaHoraInicioBetween(citaExistente.getMedico(), nuevaFechaHoraInicio, nuevaFechaHoraFin);
        if (medicoTieneCita) {
            throw new IllegalArgumentException("El médico ya tiene una cita programada en el mismo rango de horario.");
        }

        boolean usuarioTieneCita = repo.existsCitaByUsuarioAndFechaHoraInicioBetween(citaExistente.getUsuario(), nuevaFechaHoraInicio, nuevaFechaHoraFin);
        if (usuarioTieneCita) {
            throw new IllegalArgumentException("El usuario ya tiene una cita programada en el mismo rango de horario.");
        }

        citaExistente.setFechaHoraInicio(nuevaFechaHoraInicio);
        citaExistente.setFechaHoraFin(nuevaFechaHoraFin);

        EstatusModel nuevoEstatus = estatusRepository.getById(2L);
        citaExistente.setEstatus(nuevoEstatus);

        return repo.save(citaExistente);
    }




    public CitaModel cancelarCita(Long idCita) {
        Optional<CitaModel> citaOptional = repo.findById(idCita);
        CitaModel citaExistente = citaOptional.orElseThrow(() -> new NoSuchElementException("No se encontró la cita con el ID proporcionado."));

        EstatusModel estatusCancelado = estatusRepository.getById(3L);
        citaExistente.setEstatus(estatusCancelado);

        return repo.save(citaExistente);
    }
    
    
    
    


}
