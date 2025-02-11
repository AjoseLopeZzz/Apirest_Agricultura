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
public class ComentariosDTO {
    private ObjectId comentarioId;
    private ObjectId usuarioId;
    private ObjectId proyectoId;
    private String texto;
    private String tipo;
}
