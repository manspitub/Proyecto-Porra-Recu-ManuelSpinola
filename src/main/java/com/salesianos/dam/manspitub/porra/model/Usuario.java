package com.salesianos.dam.manspitub.porra.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private String imagen;
	
	private double saldo;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<ApuestaUsuario> listaApuestas;
	
	
	
	//Preguntar porque DateTime
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	public Usuario(String nombre, String apellidos, String imagen, double saldo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.imagen = imagen;
		this.saldo = saldo;
	}
	
	
}
