package com.backend.apirest.Service;

import com.backend.apirest.Model.UsuariosModel;
import com.backend.apirest.Repository.IUsuariosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IUsuariosService {
    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Override
    public String seguirUsuario(ObjectId usuarioId, ObjectId seguirId) {
        UsuariosModel usuario = usuariosRepository.findById(usuarioId).orElse(null);
        UsuariosModel seguirUsuario = usuariosRepository.findById(seguirId).orElse(null);

        if (usuario != null && seguirUsuario != null) {
            if (!usuario.getSeguidos().contains(seguirId)) {
                usuario.getSeguidos().add(seguirId);
                seguirUsuario.getSeguidores().add(usuarioId);

                usuariosRepository.save(usuario);
                usuariosRepository.save(seguirUsuario);

                return "Usuario " + usuario.getNombre() + " ahora sigue a " + seguirUsuario.getNombre();
            } else {
                return "El usuario ya está siguiendo a este usuario.";
            }
        }
        return "Usuario(s) no encontrado(s).";
    }

    @Override
    public List<ObjectId> listarSeguidores(ObjectId usuarioId) {
        UsuariosModel usuario = usuariosRepository.findById(usuarioId).orElse(null);
        if (usuario != null) {
            return usuario.getSeguidores();
        }
        return new ArrayList<>();
    }

    @Override
    public String GuardarUsuario(UsuariosModel usuario) {
        usuariosRepository.save(usuario); // Guarda el usuario en la base de datos
        return "Usuario guardado exitosamente";
    }

    @Override
    public UsuariosModel obtenerUsuarioPorId(ObjectId usuarioId) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findById(usuarioId);
        return usuarioOpt.orElse(null); // Devuelve el usuario si existe, de lo contrario devuelve null
    }
}

