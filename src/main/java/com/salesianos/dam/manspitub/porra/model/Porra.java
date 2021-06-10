package com.salesianos.dam.manspitub.porra.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Porra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String equipoLocal;
	
	private String equipoVisitante;
	
	private LocalDateTime fechaCreacion;
	
	@OneToMany(mappedBy = "porra", fetch = FetchType.EAGER)
	private List<ApuestaUsuario> listadoApuestas;
	
	public void addApuestaUsuario(ApuestaUsuario ap) {
		this.listadoApuestas.add(ap);
		ap.setPorra(this);
	}
	public void removeApuestaUsuario(ApuestaUsuario ap) {
		this.listadoApuestas.remove(ap);
		ap.setPorra(this);
	}
	public Porra(String nombre, String descripcion, String equipoLocal, String equipoVisitante
			) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}
	
	
	
	
}
