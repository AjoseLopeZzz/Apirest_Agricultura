package com.backend.apirest.Controller;

import com.backend.apirest.Model.ProyectosModel;
import com.backend.apirest.DTO.ProyectosDTO;
import com.backend.apirest.Service.IProyectosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apirest/Proyectos")
public class ProyectosController {

    @Autowired
    private IProyectosService proyectosService;

    // Crear Proyecto
    @PostMapping("/crear")
    public ResponseEntity<String> crearProyecto(@RequestBody ProyectosDTO proyectoDTO) {
        // Verificar si el usuario asociado al proyecto existe
        if (proyectosService.obtenerUsuarioPorId(proyectoDTO.getUsuarioId()) == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }

        // Crear el proyecto
        ProyectosModel proyecto = new ProyectosModel();
        proyecto.setTitulo(proyectoDTO.getTitulo());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setUsuarioId(proyectoDTO.getUsuarioId());

        // Guardar el proyecto
        proyectosService.GuardarProyecto(proyecto);

        // Responder con mensaje de éxito
        return new ResponseEntity<>("Proyecto creado exitosamente", HttpStatus.CREATED);
    }
}
