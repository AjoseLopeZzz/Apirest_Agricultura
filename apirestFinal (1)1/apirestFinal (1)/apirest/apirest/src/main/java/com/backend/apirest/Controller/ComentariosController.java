package com.backend.apirest.Controller;

import com.backend.apirest.Model.ComentariosModel;
import com.backend.apirest.DTO.ComentariosDTO;
import com.backend.apirest.Service.IComentariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apirest/Comentarios")
public class ComentariosController {

    @Autowired
    private IComentariosService comentariosService;

    // Crear Comentario
    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentariosDTO comentarioDTO) {
        // Crear el comentario
        ComentariosModel comentario = new ComentariosModel();
        comentario.setUsuarioId(comentarioDTO.getUsuarioId());
        comentario.setProyectoId(comentarioDTO.getProyectoId());
        comentario.setContenido(comentarioDTO.getContenido());

        // Guardar el comentario
        comentariosService.GuardarComentario(comentario);

        // Responder con mensaje de éxito
        return new ResponseEntity<>("Comentario creado exitosamente", HttpStatus.CREATED);
    }
}
