package com.backend.apirest.DTO;

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
    private String apellido;  // Agregado el apellido (si es necesario)
    private String email;  // Para identificar al usuario
    private String password;  // Si se va a crear un usuario con contraseña
    private List<ObjectId> seguidores;  // Campo para manejar seguidores
}
