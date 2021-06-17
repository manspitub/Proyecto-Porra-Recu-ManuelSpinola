package com.salesianos.dam.manspitub.porra.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private String imagen;
	
	private double saldo;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ApuestaUsuario> listaApuestas = new ArrayList<>();
	
	public void addApuestaUsuario(ApuestaUsuario ap) {
		this.listaApuestas.add(ap);
		ap.setUsuario(this);
	}
	
	public void removeApuestaUsuario(ApuestaUsuario ap) {
		this.listaApuestas.remove(ap);
		ap.setUsuario(this);
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	public Usuario(String nombre, String apellidos, String imagen, double saldo, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.imagen = imagen;
		this.saldo = saldo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String nombre, String apellidos, double saldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
	}
	
	
	
	
	
	
	
	
}
