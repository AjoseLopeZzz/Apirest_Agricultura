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
public class ComentariosDTO {
    private ObjectId usuarioId;  // El ID del usuario que comenta
    private ObjectId proyectoId;  // El ID del proyecto al que pertenece el comentario
    private String contenido;  // El contenido del comentario
}
