package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.CitaModel;
import com.backend.MediSite.Services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Cita")
public class CitaController {


    @Autowired
    private CitaService citaService;

    @PostMapping("/Create")
    public CitaModel create(@RequestBody CitaModel cita){
        return this.citaService.Create(cita);
    }



}
