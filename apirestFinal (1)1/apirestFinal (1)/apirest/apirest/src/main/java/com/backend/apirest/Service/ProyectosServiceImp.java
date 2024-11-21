package com.backend.apirest.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.Model.ProyectosModel;
import com.backend.apirest.Model.UsuariosModel;
import com.backend.apirest.Repository.IProyectosRepository;
import com.backend.apirest.Repository.IUsuariosRepository;

@Service
public class ProyectosServiceImp implements IProyectosService {
    @Autowired 
    private IProyectosRepository proyectosRepository;
    @Autowired
    private IUsuariosRepository usuariosRepository;

   

    @Override
    public String GuardarProyecto(ProyectosModel proyecto) {
        proyectosRepository.save(proyecto);
        return "El proyecto " + proyecto.getTitulo() + " fue creado con éxito.";
    }



    @Override
    public UsuariosModel obtenerUsuarioPorId(ObjectId usuarioId) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findById(usuarioId);
        return usuarioOpt.orElse(null); // Devuelve el usuario si existe, de lo contrario devuelve null
    }
}
