package com.backend.apirest.Model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Mensajes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajesModel {
    private ObjectId id;
    private ObjectId emisorId;
    private ObjectId receptorId;
    private String texto;
    private List<AdjuntoMultimedia> adjuntosMultimedia;
    private List<AdjuntoDocPdf> adjuntosDocPdf;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdjuntoMultimedia {
        private String tipo;
        private String archivo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdjuntoDocPdf {
        private String nombre;
        private String url;
    }
}
