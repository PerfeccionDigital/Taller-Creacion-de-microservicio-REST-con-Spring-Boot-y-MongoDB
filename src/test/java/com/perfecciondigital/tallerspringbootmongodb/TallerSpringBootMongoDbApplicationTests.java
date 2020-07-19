package com.perfecciondigital.tallerspringbootmongodb;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.perfecciondigital.tallerspringbootmongodb.model.Notificacion;
import com.perfecciondigital.tallerspringbootmongodb.service.NotificacionService;

@SpringBootTest
class TallerSpringBootMongoDbApplicationTests {
	
	@Autowired
	private NotificacionService service;

	@Test
	void contextLoads() {
		Notificacion notificacion = new Notificacion();
		notificacion.setMensaje("Mensaje");
		notificacion.setDetalle("Mensaje detallado");
		notificacion.setEstado("ACTIVO");
		service.add(notificacion);
		
		List<Notificacion> notificacionList = service.findAll();
		for (Notificacion notificacion2 : notificacionList) {
			System.out.println(notificacion2);
		}
	}

}
