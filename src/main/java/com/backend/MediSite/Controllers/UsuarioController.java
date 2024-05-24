package com.backend.MediSite.Controllers;

import com.backend.MediSite.Models.UsuarioModel;
import com.backend.MediSite.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/Create")
    public UsuarioModel Create(@RequestBody UsuarioModel Usuario){
        return this.usuarioService.Create(Usuario);
    }

    @GetMapping("/Read")
    public ArrayList<UsuarioModel> Read(){
        return this.usuarioService.Read();
    }

    @GetMapping("/UsuarioById/{IdUsuario}")
    public Optional<UsuarioModel> UsuarioById(@PathVariable("IdUsuario") Long IdUsuario){
        return this.usuarioService.UsuarioById(IdUsuario);
    }


    @PutMapping("/Update/{IdUsuario}")
    public UsuarioModel Update(@RequestBody UsuarioModel request, @PathVariable Long IdUsuario){
        return this.usuarioService.Update(request, IdUsuario);
    }

    @DeleteMapping("/Delete/{IdUsuario}")
    public String Delete(@PathVariable("IdUsuario") Long IdUsuario){
        boolean ok = this.usuarioService.Delete(IdUsuario);
        if(ok){
            return "Usuario con Id " + IdUsuario + " eliminado correctamente";
        }
        else{
            return "No se pudo eliminar el usuario con Id " + IdUsuario;
        }
    }


}
