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
public class MensajesDTO {
    private ObjectId mensajeId;
    private ObjectId emisorId;
    private ObjectId receptorId;
    private String texto;
    private String tipoAdjunto;
    private String urlAdjunto;
}
