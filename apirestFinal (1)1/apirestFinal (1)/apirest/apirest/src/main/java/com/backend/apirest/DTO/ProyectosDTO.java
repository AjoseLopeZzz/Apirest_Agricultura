package com.backend.apirest.DTO;

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
    private String titulo;  // El estado del proyecto (activo, en progreso, completado, etc.)
    private String descripcion;  // El tipo de cultivo para el proyecto
    private ObjectId usuarioId;  // El ID del usuario que crea el proyecto
}
