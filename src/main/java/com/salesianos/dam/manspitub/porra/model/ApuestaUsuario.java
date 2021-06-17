package com.salesianos.dam.manspitub.porra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor 
/**
 * Clase que guarda las apuestas de los usuarios
 * @author MANSPITUB
 *
 */
public class ApuestaUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Resultado como 1, X o 2
	 */
	private String resultado;
	/**
	 * El dinero que se apuesta
	 */
	private double dineroApostado;
	
	/**
	 * Asociación Many to One con un usuario
	 */
	@ManyToOne
	private Usuario usuario;
	/**
	 * Asociación Many to One con una porra
	 */
	@ManyToOne
	private Porra porra;

	public ApuestaUsuario(String resultado, double dineroApostado, Usuario usuario, Porra porra) {
		super();
		this.resultado = resultado;
		this.dineroApostado = dineroApostado;
		this.usuario = usuario;
		this.porra = porra;
	}
	/**
	 * Método que guarda los resultados posibles
	 * @return 1, x o 2
	 */
	public static List<String> tipos_resultados() {
		return List.of("1", 
				"X",
				"2");
	}
	
}
