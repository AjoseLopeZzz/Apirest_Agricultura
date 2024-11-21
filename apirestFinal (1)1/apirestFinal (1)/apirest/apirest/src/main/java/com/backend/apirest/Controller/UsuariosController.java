package com.backend.apirest.Controller;

import com.backend.apirest.Model.UsuariosModel;
import com.backend.apirest.DTO.UsuariosDTO;
import com.backend.apirest.Service.IUsuariosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apirest/Usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosService usuariosService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        // Crear nuevo usuario a partir del DTO
        UsuariosModel usuario = new UsuariosModel();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());

        // Manejo de seguidores
        List<ObjectId> seguidores = usuarioDTO.getSeguidores();
        if (seguidores != null) {
            for (ObjectId seguidorId : seguidores) {
                // Asociar seguidores al usuario si existen
                UsuariosModel seguidor = usuariosService.obtenerUsuarioPorId(seguidorId);
                if (seguidor != null) {
                    usuario.getSeguidores().add(seguidor.getId());
                }
            }
        }

        // Guardar usuario en la base de datos
        String resultado = usuariosService.GuardarUsuario(usuario);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    // Método para seguir a otro usuario
    @PostMapping("/seguir/{usuarioId}/{seguirId}")
    public ResponseEntity<String> seguirUsuario(@PathVariable ObjectId usuarioId, @PathVariable ObjectId seguirId) {
        String resultado = usuariosService.seguirUsuario(usuarioId, seguirId);
        if ("Usuario no encontrado".equals(resultado)) {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ahora estás siguiendo a este usuario.", HttpStatus.OK);
    }

    // Método para listar los seguidores de un usuario
    @GetMapping("/seguidores/{usuarioId}")
    public ResponseEntity<List<ObjectId>> listarSeguidores(@PathVariable ObjectId usuarioId) {
        List<ObjectId> seguidores = usuariosService.listarSeguidores(usuarioId);
        if (seguidores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Si no tiene seguidores
        }
        return new ResponseEntity<>(seguidores, HttpStatus.OK);
    }
}
