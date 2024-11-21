package com.backend.apirest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.Model.MensajesModel;
import com.backend.apirest.Repository.IMensajesRepository;

@Service
public class MensajesServiceImp implements IMensajesService {
    @Autowired 
    private IMensajesRepository mensajesRepository;

   

    @Override
    public String GuardarMensaje(MensajesModel mensaje) {
        mensajesRepository.save(mensaje);
        return "El mensaje fue creado con éxito.";
       
    }
}
