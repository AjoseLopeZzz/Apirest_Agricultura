package com.backend.apirest.Model.DTO;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDTO {
    private String nombre;
    private Date fecha;
    private List<ObjectId> seguidores;  // Campo para manejar seguidores
}
