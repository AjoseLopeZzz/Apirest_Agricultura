package com.backend.apirest.Model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Comentarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentariosModel {
    private ObjectId id;
    private Object usuarioId;
    private ObjectId proyectoId;
    private String contenido;
    private List<Adjunto> adjuntos;
    private List<Replica> replicas;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Adjunto {
        private String tipo;
        private String archivo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Replica {
        private String usuarioId;
        private String contenido;
        private List<Adjunto> adjuntos;
    }
    
    public void setContenido(String contenido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContenido'");
    }

}
