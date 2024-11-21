package com.backend.apirest.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apirest.Model.UsuariosModel;
import com.backend.apirest.Service.IUsuariosService;

@RestController
@RequestMapping("/UAO/apirest/Usuarios")
public class UsuariosController {
    @Autowired
    private IUsuariosService usuariosService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuariosModel usuario) {
        return new ResponseEntity<>(usuariosService.GuardarUsuario(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/seguir/{usuarioId}/{seguirId}")
    public ResponseEntity<String> seguirUsuario(@PathVariable ObjectId usuarioId, @PathVariable ObjectId seguirId) {
        return new ResponseEntity<>(usuariosService.seguirUsuario(usuarioId, seguirId), HttpStatus.OK);
    }

    @GetMapping("/listarSeguidores/{usuarioId}")
    public ResponseEntity<List<ObjectId>> listarSeguidores(@PathVariable ObjectId usuarioId) {
        return new ResponseEntity<>(usuariosService.listarSeguidores(usuarioId), HttpStatus.OK);
    }
}

