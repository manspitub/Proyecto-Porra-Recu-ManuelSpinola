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
public class ApuestaUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String resultado;
	private double dineroApostado;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Porra porra;

	public ApuestaUsuario(String resultado, double dineroApostado, Usuario usuario, Porra porra) {
		super();
		this.resultado = resultado;
		this.dineroApostado = dineroApostado;
		this.usuario = usuario;
		this.porra = porra;
	}
	
	public static List<String> tipos_resultados() {
		return List.of("1", 
				"X",
				"2");
	}
	
}
