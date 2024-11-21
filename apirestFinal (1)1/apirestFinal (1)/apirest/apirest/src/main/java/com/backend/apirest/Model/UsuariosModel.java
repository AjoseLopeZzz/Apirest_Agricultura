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
    private String email;
    private String password;
    private Date fecha;
    private List<ObjectId> seguidores = new ArrayList<>();  // Usuarios que siguen a este usuario
    private List<ObjectId> seguidos = new ArrayList<>();    // Usuarios que este usuario sigue

    private String apellido;

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Método getter para email
    public String getEmail() {
        return email;
    }

    // Método setter para password
    public void setPassword(String password) {
        this.password = password;
    }

    // Método getter para password
    public String getPassword() {
        return password;
    }
}
