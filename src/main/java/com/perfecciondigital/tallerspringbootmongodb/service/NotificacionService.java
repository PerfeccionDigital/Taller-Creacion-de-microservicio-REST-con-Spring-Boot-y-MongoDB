package com.perfecciondigital.tallerspringbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfecciondigital.tallerspringbootmongodb.model.Notificacion;
import com.perfecciondigital.tallerspringbootmongodb.repository.NotificacionReporitory;

@Service
public class NotificacionService {
	
	@Autowired
	private NotificacionReporitory notificacionReporitory;
	
	public List<Notificacion> findAll(){
		return notificacionReporitory.findAll();
	}
	
	public Notificacion findById(String id){
		Notificacion notificacion = null;
		 Optional<Notificacion> result = notificacionReporitory.findById(id);
		 if(result.isPresent()) {
			 notificacion = result.get();
		 }
		 return notificacion;
	}
	
	public Notificacion add(Notificacion notificacion) {
		String mensaje = notificacion.getMensaje();
		if(mensaje != null) {
			notificacion.setMensaje(mensaje.toUpperCase());
		}

		return notificacionReporitory.save(notificacion);
	}
	
	public Notificacion update(Notificacion notificacion) {
		
		String mensaje = notificacion.getMensaje();
		if(mensaje != null) {
			notificacion.setMensaje(mensaje.toUpperCase());
		}

		return notificacionReporitory.save(notificacion);
	}
	
	public void deleteById(String id) {
		notificacionReporitory.deleteById(id);
	}

}
