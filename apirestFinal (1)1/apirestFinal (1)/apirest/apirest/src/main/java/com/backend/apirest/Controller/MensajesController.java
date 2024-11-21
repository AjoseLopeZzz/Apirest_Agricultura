package com.backend.apirest.Controller;

import com.backend.apirest.Model.MensajesModel;
import com.backend.apirest.DTO.MensajesDTO;
import com.backend.apirest.Service.IMensajesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apirest/Mensajes")
public class MensajesController {

    @Autowired
    private IMensajesService mensajesService;

    // Enviar Mensaje
    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMensaje(@RequestBody MensajesDTO mensajeDTO) {
        // Crear el mensaje
        MensajesModel mensaje = new MensajesModel();
        mensaje.setEmisorId(mensajeDTO.getEmisorId());
        mensaje.setReceptorId(mensajeDTO.getReceptorId());
        mensaje.setContenido(mensajeDTO.getContenido());

        // Guardar el mensaje
        mensajesService.GuardarMensaje(mensaje);

        // Responder con mensaje de éxito
        return new ResponseEntity<>("Mensaje enviado exitosamente", HttpStatus.CREATED);
    }
}
