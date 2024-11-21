package com.backend.apirest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apirest.Model.DTO.ProyectosDTO;
import com.backend.apirest.Model.ProyectosModel;
import com.backend.apirest.Service.IProyectosService;

@RestController
@RequestMapping("/apirest/Proyectos")
public class ProyectosController {

    @Autowired
    public  IProyectosService proyectosService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearProyecto(@RequestBody ProyectosDTO proyectoDTO) {
        ProyectosModel proyecto = new ProyectosModel();
        proyecto.setUsuarioId(proyectoDTO.getUsuarioId());
        proyecto.setEstado(proyectoDTO.getEstado());
        proyecto.setTipoCultivo(proyectoDTO.getTipoCultivo());

        proyectosService.GuardarProyecto(proyecto);
        return new ResponseEntity<>("Proyecto creado exitosamente", HttpStatus.CREATED);
    }
}
