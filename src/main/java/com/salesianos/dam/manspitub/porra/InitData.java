package com.salesianos.dam.manspitub.porra;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianos.dam.manspitub.porra.model.ApuestaUsuario;
import com.salesianos.dam.manspitub.porra.model.Porra;
import com.salesianos.dam.manspitub.porra.model.Usuario;
import com.salesianos.dam.manspitub.porra.service.ApuestaUsuarioService;
import com.salesianos.dam.manspitub.porra.service.PorraService;
import com.salesianos.dam.manspitub.porra.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioService usuarioService;
	private final PorraService porraService;
	//private final ApuestaUsuarioService aUService;
	
	@PostConstruct
	public void init() {
		
		Usuario a1 = new Usuario("Manuel", "Spinola Tubio" , "https://image.freepik.com/vector-gratis/perfil-avatar-hombre-icono-redondo_24640-14044.jpg" , 200);
		Usuario a2 = new Usuario("Pepe", "Perez", 150);
		Usuario a3 = new Usuario("María", "Chávez", "https://image.freepik.com/vector-gratis/perfil-avatar-mujer-icono-redondo_24640-14047.jpg", 300);
		
		usuarioService.save(a1);
		usuarioService.save(a2);
		usuarioService.save(a3);
		
		Porra p1 = new Porra("Betis-Sevilla", "Descripción de porra", "Betis", "Sevilla");
		Porra p2 = new Porra("Madrid-Barça", "Descripción de porra", "Real Madrid", "FC Barcelona");
		Porra p3 = new Porra("Atletico de madrid-Celta de vigo", "Descripción de porra", "Atleti", "Celta de vigo");
		
		porraService.save(p1);
		porraService.save(p2);
		porraService.save(p3);
		
//		List<ApuestaUsuario> apuestaUsuarios = List.of(new ApuestaUsuario("1", 100, a1, p1),
//				new ApuestaUsuario("X", 200, a2, p2),
//				new ApuestaUsuario("2", 300, a3, p3));
//		apuestaUsuarios.forEach(aUService::save);
	}
	
}
