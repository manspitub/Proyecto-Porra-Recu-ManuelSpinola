package com.salesianos.dam.manspitub.porra.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class ApuestaUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String resultado;
	private double dineroApostado;
	
	@OneToMany
	private Usuario usuarios;
	
	@OneToMany
	private Porra porra;
}
