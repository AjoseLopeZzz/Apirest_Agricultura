package com.backend.apirest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.Model.ProyectosModel;
import com.backend.apirest.Repository.IProyectosRepository;

@Service
public class ProyectosServiceImp implements IProyectosService {
    @Autowired 
    private IProyectosRepository proyectosRepository;

   

    @Override
    public String GuardarProyecto(ProyectosModel proyecto) {
        proyectosRepository.save(proyecto);
        return "El proyecto " + proyecto.getNombre() + " fue creado con éxito.";
    }
}
