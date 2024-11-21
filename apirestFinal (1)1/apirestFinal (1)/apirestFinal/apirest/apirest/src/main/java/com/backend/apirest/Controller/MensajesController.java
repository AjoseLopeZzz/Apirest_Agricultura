package com.backend.apirest.Controller;

import com.backend.apirest.Model.MensajesModel;
import com.backend.apirest.Model.DTO.MensajesDTO;
import com.backend.apirest.Service.IMensajesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensajes")
public class MensajesController {

    @Autowired
    private IMensajesService mensajesService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMensaje(@RequestBody MensajesDTO mensajeDTO) {
        MensajesModel mensaje = new MensajesModel();
        mensaje.setEmisorId(mensajeDTO.getEmisorId());
        mensaje.setReceptorId(mensajeDTO.getReceptorId());
        mensaje.setTexto(mensajeDTO.getTexto());

        mensajesService.GuardarMensaje(mensaje);
        return new ResponseEntity<>("Mensaje enviado exitosamente", HttpStatus.CREATED);
    }
}
