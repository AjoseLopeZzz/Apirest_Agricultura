package com.backend.apirest.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.apirest.Model.MensajesModel;

public interface IMensajesRepository extends MongoRepository<MensajesModel, ObjectId> {
    
}
