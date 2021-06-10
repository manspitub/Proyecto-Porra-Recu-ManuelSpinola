package com.salesianos.dam.manspitub.porra;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianos.dam.manspitub.porra.model.ApuestaUsuario;
import com.salesianos.dam.manspitub.porra.model.Porra;
import com.salesianos.dam.manspitub.porra.model.Usuario;
import com.salesianos.dam.manspitub.porra.service.PorraService;
import com.salesianos.dam.manspitub.porra.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioService usuarioService;
	private final PorraService porraService;
	
	@PostConstruct
	public void init() {
		
		List<Usuario> usuarios = List.of(new Usuario("Manuel", "Spinola Tubio" , "https://image.freepik.com/vector-gratis/perfil-avatar-hombre-icono-redondo_24640-14044.jpg" , 200),
				new Usuario("Pepe", "Perez", "https://i.blogs.es/66b2a4/photo-1511367461989-f85a21fda167/1366_2000.jpeg", 150),
				new Usuario("María", "Chávez", "https://image.freepik.com/vector-gratis/perfil-avatar-mujer-icono-redondo_24640-14047.jpg", 300));
		List<Porra> porras = List.of(new Porra("Betis-Sevilla", "Descripción de porra", "Betis", "Sevilla"),
				new Porra("Madrid-Barça", "Descripción de porra", "Real Madrid", "FC Barcelona"),
				new Porra("Atletico de madrid-Celta de vigo", "Descripción de porra", "Atleti", "Celta de vigo"));
		List<ApuestaUsuario> apuestaUsuarios = List.of(new ApuestaUsuario);
	}
}
