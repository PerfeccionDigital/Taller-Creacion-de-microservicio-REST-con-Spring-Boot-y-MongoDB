package com.perfecciondigital.tallerspringbootmongodb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Notificacion {

	@Id
	private String id;
	
	private String mensaje;
	
	private String detalle;
	
	private String estado;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@CreatedDate
	private LocalDateTime fechaCreacion;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@LastModifiedDate
	private LocalDateTime fechaModificacion;
	
}
