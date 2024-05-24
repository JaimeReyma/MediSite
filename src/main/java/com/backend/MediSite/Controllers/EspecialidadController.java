package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.EspecialidadModel;
import com.backend.MediSite.Services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;


    @PostMapping("/Create")
    public EspecialidadModel Create(@RequestBody EspecialidadModel Especialidad){
        return this.especialidadService.Create(Especialidad);
    }

    @GetMapping("/Read")
    public ArrayList<EspecialidadModel> Read(){
        return this.especialidadService.Read();
    }

    @GetMapping("/EspecialidadById/{IdEspecialidad}")
    public Optional<EspecialidadModel> EspecialidadById(@PathVariable ("IdEspecialidad") Long IdEspecialidad){
        return this.especialidadService.EspecialidadById(IdEspecialidad);
    }

    @PutMapping("/Update/{IdEspecialidad}")
    public EspecialidadModel Update(@RequestBody EspecialidadModel request, @PathVariable Long IdEspecialidad){
        return this.especialidadService.Update(request, IdEspecialidad);
    }

    @DeleteMapping("/Delete/{IdEspecialidad}")
    public String Delete(@PathVariable("IdEspecialidad") Long IdEspecialidad){
        boolean ok = this.especialidadService.Delete(IdEspecialidad);
        if(ok){
            return "Especialidad con Id " + IdEspecialidad + " eliminado correctamente";
        }
        else{
            return "No se pudo eliminar la especialidad con Id " + IdEspecialidad;
        }
    }



}
