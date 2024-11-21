package com.backend.apirest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.Model.ComentariosModel;
import com.backend.apirest.Repository.IComentariosRepository;

@Service
public class ComentariosServiceImp implements IComentariosService {
    @Autowired 
    private IComentariosRepository comentariosRepository;

 

    @Override
    public String GuardarComentario(ComentariosModel comentario) {
        comentariosRepository.save(comentario);
        return "El comentario fue creado con éxito.";

       
    }
}
