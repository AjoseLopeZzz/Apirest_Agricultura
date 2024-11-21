package com.backend.apirest.Model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Proyectos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectosModel {
    private ObjectId id;
    private ObjectId usuarioId;
    private List<String> fotos;
    private String estado;
    private List<Colaborador> colaboradores;
    private String tipoCultivo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Colaborador {
        private String usuarioId;
        private String nombre;
        private String estado;
    }

    public String getNombre() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }
}
