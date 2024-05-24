package com.backend.MediSite.Services;

import com.backend.MediSite.Models.CitaModel;
import com.backend.MediSite.Models.EstatusModel;
import com.backend.MediSite.Models.MedicoModel;
import com.backend.MediSite.Models.UsuarioModel;
import com.backend.MediSite.Repositories.ICita;
import com.backend.MediSite.Repositories.IEstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        // Verificar si el médico tiene una cita en el mismo rango de horario
        boolean medicoTieneCita = repo.existsCitaByMedicoAndFechaHoraInicioBetween(cita.getMedico(), cita.getFechaHoraInicio(), cita.getFechaHoraFin());
        if (medicoTieneCita) {
            throw new IllegalArgumentException("El médico ya tiene una cita programada en el mismo rango de horario.");
        }

        // Verificar si el usuario tiene una cita en el mismo rango de horario
        boolean usuarioTieneCita = repo.existsCitaByUsuarioAndFechaHoraInicioBetween(cita.getUsuario(), cita.getFechaHoraInicio(), cita.getFechaHoraFin());
        if (usuarioTieneCita) {
            throw new IllegalArgumentException("El usuario ya tiene una cita programada en el mismo rango de horario.");
        }

        // Crear un nuevo objeto de estatus
        EstatusModel estatus = estatusRepository.getById(1L);
        cita.setEstatus(estatus);

        // Guardar la nueva cita en la base de datos
        return repo.save(cita);
    }
}
