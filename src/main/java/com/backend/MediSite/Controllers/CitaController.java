package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.CitaModel;
import com.backend.MediSite.Models.CiudadModel;
import com.backend.MediSite.Services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/Cita")
public class CitaController {


    @Autowired
    private CitaService citaService;

    @PostMapping("/Create")
    public CitaModel create(@RequestBody CitaModel cita){
        return this.citaService.Create(cita);
    }

    @GetMapping("/CitaById/{IdCita}")
    public Optional<CitaModel> CitaById(@PathVariable ("IdCita") Long IdCita){
        return this.citaService.CitaById(IdCita);
    }

    @PutMapping("/Update/{idCita}")
    public CitaModel update(@PathVariable Long idCita, @RequestParam LocalDateTime nuevaFechaHoraInicio, @RequestParam LocalDateTime nuevaFechaHoraFin) {
        return citaService.actualizarCita(idCita, nuevaFechaHoraInicio, nuevaFechaHoraFin);
    }

    @PutMapping("/Cancelar/{idCita}")
    public CitaModel cancelarCita(@PathVariable Long idCita) {
        return citaService.cancelarCita(idCita);
    }



}
