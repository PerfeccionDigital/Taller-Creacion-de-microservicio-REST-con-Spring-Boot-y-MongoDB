package com.perfecciondigital.tallerspringbootmongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfecciondigital.tallerspringbootmongodb.model.Notificacion;
import com.perfecciondigital.tallerspringbootmongodb.service.NotificacionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/notificacion")
public class NotificacionController {

	@Autowired
	private NotificacionService notificacionService;
	
	@GetMapping
	public ResponseEntity<List<Notificacion>> get() {
		HttpStatus status = null;
		List<Notificacion> notificacionList = new ArrayList<>();
		try {
			notificacionList = notificacionService.findAll();
			if(notificacionList.size()>0) {
				status = HttpStatus.OK;
			}else {
				status = HttpStatus.NO_CONTENT;	
			}
		} catch (Exception e) {
			log.error("Exception", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Notificacion>>(notificacionList, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Notificacion> getById(@PathVariable("id") String id) {
		HttpStatus status = null;
		Notificacion notificacion = new Notificacion();
		try {
			notificacion = notificacionService.findById(id);
			if(notificacion != null) {
				status = HttpStatus.OK;	
			}else {
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			log.error("Exception", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Notificacion>(notificacion, status);
	}
	
	@PostMapping
	public ResponseEntity<Notificacion> post(@RequestBody Notificacion notificacion) {
		HttpStatus status = null;
		Notificacion notificacionTmp = new Notificacion();
		try {
			notificacionTmp = notificacionService.add(notificacion);
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			log.error("Exception", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(status).body(notificacionTmp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Notificacion> put(@RequestBody Notificacion notificacion, @PathVariable("id") String id) {
		HttpStatus status = null;
		Notificacion notificacionTmp = new Notificacion();
		try {
			notificacion.setId(id);
			notificacionTmp = notificacionService.update(notificacion);
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			log.error("Exception", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(status).body(notificacionTmp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Notificacion> delete(@PathVariable("id") String id) {
		HttpStatus status = null;
		try {
			notificacionService.deleteById(id);
			status = HttpStatus.OK;	
		} catch (Exception e) {
			log.error("Exception", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Notificacion>(status);
	}
	
}
