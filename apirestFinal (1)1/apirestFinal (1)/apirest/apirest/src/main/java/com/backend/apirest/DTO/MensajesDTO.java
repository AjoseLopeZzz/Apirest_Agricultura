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
public class MensajesDTO {
    private ObjectId emisorId;  // El ID del emisor del mensaje
    private ObjectId receptorId;  // El ID del receptor del mensaje
    private String contenido;  // El contenido del mensaje
}
