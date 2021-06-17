package com.salesianos.dam.manspitub.porra.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
/**
 * Clase porra que registra una porra
 * @author MANSPITUB
 *
 */
public class Porra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Nombre de la porra
	 */
	private String nombre;
	
	/***
	 * Descripción de la porra
	 */
	private String descripcion;
	/***
	 * El equipo Local
	 */
	private String equipoLocal;
	/**
	 * Equipo Visitante
	 */
	private String equipoVisitante;
	/**
	 * No se incluye en la lista. Muestra la fecha de creación de la porra
	 */
	private LocalDateTime fechaCreacion;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	/**
	 * Asociación One to Many con apuesta usuario con borrado en cascada
	 */
	@OneToMany(mappedBy = "porra", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ApuestaUsuario> listadoApuestas;
	
	/**
	 * Añade una apuesta de Usuario
	 * @param ap
	 */
	public void addApuestaUsuario(ApuestaUsuario ap) {
		this.listadoApuestas.add(ap);
		ap.setPorra(this);
	}
	/**
	 * Borra una apuesta de usuario
	 * @param ap
	 */
	public void removeApuestaUsuario(ApuestaUsuario ap) {
		this.listadoApuestas.remove(ap);
		ap.setPorra(this);
	}
	/**
	 * Constructor sin fecha creación
	 * @param nombre
	 * @param descripcion
	 * @param equipoLocal
	 * @param equipoVisitante
	 */
	public Porra(String nombre, String descripcion, String equipoLocal, String equipoVisitante
			) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}
	
	
	
	
}
