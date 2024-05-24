package com.backend.MediSite.Services;

import com.backend.MediSite.Models.UsuarioModel;
import com.backend.MediSite.Repositories.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuario repo;


    public UsuarioModel Create(UsuarioModel Usuario){
        if (Usuario.getNombreUsuario() == null || Usuario.getCiudad() == null) {
            throw new IllegalArgumentException("No se permiten valores nulos en las columnas 'NombreUsuario' y 'Ciudad'.");
        }
        return repo.save(Usuario);
    }

    public ArrayList<UsuarioModel> Read(){
        return (ArrayList<UsuarioModel>) repo.findAll();
    }

    public Optional<UsuarioModel> UsuarioById(Long IdUsuario){
        return repo.findById(IdUsuario);
    }

    public UsuarioModel Update(UsuarioModel request, Long IdUsuario) {
        Optional<UsuarioModel> usuarioOptional = repo.findById(IdUsuario);
        if (!usuarioOptional.isPresent()) {
            throw new IllegalArgumentException("No se encuentra el usuario con ese Id.");
        }

        UsuarioModel usuario = usuarioOptional.get();
        usuario.setNombreUsuario(request.getNombreUsuario());
        usuario.setCiudad(request.getCiudad());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());

        return repo.save(usuario);
    }

    public Boolean Delete (Long IdUsuario){
        try {
            repo.deleteById(IdUsuario);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
