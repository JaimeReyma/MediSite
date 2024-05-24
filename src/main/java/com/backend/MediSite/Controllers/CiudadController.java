package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.CiudadModel;
import com.backend.MediSite.Services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;


    @PostMapping("/Create")
    public CiudadModel Create(@RequestBody CiudadModel Ciudad){
        return this.ciudadService.Create(Ciudad);
    }

    @GetMapping("/Read")
    public ArrayList<CiudadModel> Read(){
        return this.ciudadService.Read();
    }

    @GetMapping("/CiudadById/{IdCiudad}")
    public Optional<CiudadModel> CiudadById(@PathVariable ("IdCiudad") Long IdCiudad){
        return this.ciudadService.CiudadById(IdCiudad);
    }

    @PutMapping("/Update/{IdCiudad}")
    public CiudadModel Update(@RequestBody CiudadModel request, @PathVariable Long IdCiudad){
        return this.ciudadService.Update(request, IdCiudad);
    }

    @DeleteMapping("/Delete/{IdCiudad}")
    public String Delete(@PathVariable("IdCiudad") Long IdCiudad){
        boolean ok = this.ciudadService.Delete(IdCiudad);
        if(ok){
            return "Ciudad con Id " + IdCiudad + " eliminado correctamente";
        }
        else{
            return "No se pudo eliminar la ciudad con Id " + IdCiudad;
        }
    }



}
