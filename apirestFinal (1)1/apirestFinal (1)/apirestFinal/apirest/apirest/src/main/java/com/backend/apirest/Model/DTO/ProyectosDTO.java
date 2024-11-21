package com.backend.apirest.Model.DTO;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectosDTO {
    private ObjectId proyectoId;
    private ObjectId usuarioId;
    private String nombre;
    private String estado;
    private String tipoCultivo;
}
