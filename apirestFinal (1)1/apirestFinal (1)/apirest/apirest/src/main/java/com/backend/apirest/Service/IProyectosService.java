package com.backend.apirest.Service;

import org.bson.types.ObjectId;

import com.backend.apirest.Model.ProyectosModel;

public interface IProyectosService {
    public String GuardarProyecto(ProyectosModel proyecto);

    public Object obtenerUsuarioPorId(ObjectId usuarioId);
}
