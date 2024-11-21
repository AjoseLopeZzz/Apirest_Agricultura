package com.backend.apirest.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    private ObjectId id;
    private String nombre;
    private Date fecha;
    private List<ObjectId> seguidores = new ArrayList<>();  // Usuarios que siguen a este usuario
    private List<ObjectId> seguidos = new ArrayList<>();    // Usuarios que este usuario sigue
}
