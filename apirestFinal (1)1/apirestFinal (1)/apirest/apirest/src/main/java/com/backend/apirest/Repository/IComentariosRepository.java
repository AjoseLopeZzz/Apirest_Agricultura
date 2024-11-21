package com.backend.apirest.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.apirest.Model.ComentariosModel;

public interface IComentariosRepository extends MongoRepository<ComentariosModel, ObjectId> {
    
}
