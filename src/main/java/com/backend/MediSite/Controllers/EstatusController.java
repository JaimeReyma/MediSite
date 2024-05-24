package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.EstatusModel;
import com.backend.MediSite.Services.EstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Estatus")
public class EstatusController {

    @Autowired
    private EstatusService estatusService;


    @PostMapping("/Create")
    public EstatusModel Create(@RequestBody EstatusModel Estatus){
        return this.estatusService.Create(Estatus);
    }

    @GetMapping("/Read")
    public ArrayList<EstatusModel> Read(){
        return this.estatusService.Read();
    }

    @GetMapping("/EstatusById/{IdEstatus}")
    public Optional<EstatusModel> EstatusById(@PathVariable ("IdEstatus") Long IdEstatus){
        return this.estatusService.EstatusById(IdEstatus);
    }

    @PutMapping("/Update/{IdEstatus}")
    public EstatusModel Update(@RequestBody EstatusModel request, @PathVariable Long IdEstatus){
        return this.estatusService.Update(request, IdEstatus);
    }

    @DeleteMapping("/Delete/{IdEstatus}")
    public String Delete(@PathVariable("IdEstatus") Long IdEstatus){
        boolean ok = this.estatusService.Delete(IdEstatus);
        if(ok){
            return "Estatus con Id " + IdEstatus + " eliminado correctamente";
        }
        else{
            return "No se pudo eliminar la estatus con Id " + IdEstatus;
        }
    }



}
