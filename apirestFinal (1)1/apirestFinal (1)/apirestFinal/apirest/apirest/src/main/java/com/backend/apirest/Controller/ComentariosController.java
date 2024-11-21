package com.backend.apirest.Controller;

import com.backend.apirest.Model.ComentariosModel;
import com.backend.apirest.Model.DTO.ComentariosDTO;
import com.backend.apirest.Service.IComentariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentarios")
public class ComentariosController {

    @Autowired
    private IComentariosService comentariosService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentariosDTO comentarioDTO) {
        ComentariosModel comentario = new ComentariosModel();
        comentario.setUsuarioId(comentarioDTO.getUsuarioId());
        comentario.setProyectoId(comentarioDTO.getProyectoId());
        comentario.setTexto(comentarioDTO.getTexto());

        comentariosService.GuardarComentario(comentario);
        return new ResponseEntity<>("Comentario creado exitosamente", HttpStatus.CREATED);
    }
}
