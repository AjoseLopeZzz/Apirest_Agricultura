package com.backend.apirest.Service;

import com.backend.apirest.Model.UsuariosModel;

import java.util.List;

import org.bson.types.ObjectId;

public interface IUsuariosService {
    public String GuardarUsuario(UsuariosModel usuario);
    public String seguirUsuario(ObjectId usuarioId, ObjectId seguirId);
    public List<ObjectId> listarSeguidores(ObjectId usuarioId);
}
