package com.perfecciondigital.tallerspringbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.perfecciondigital.tallerspringbootmongodb.model.Notificacion;

public interface NotificacionReporitory extends MongoRepository<Notificacion, String> {

}
