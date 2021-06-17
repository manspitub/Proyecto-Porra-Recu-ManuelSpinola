package com.salesianos.dam.manspitub.porra;

import java.time.LocalDate;
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
	private final ApuestaUsuarioService aUService;
	//private final ApuestaUsuarioService aUService;
	
	@PostConstruct
	public void init() {
		
		Usuario a1 = new Usuario("Manuel", "Spinola Tubio" , "https://tdj.gg/uploads/attachs/20560_w9RC4W-QqXw-200x200.jpg" , 200, LocalDate.of(2001, 7, 12));
		Usuario a2 = new Usuario("Pepe", "Perez", "https://cn.i.cdn.ti-platform.com/content/1106/showpage/teen-titans-go%21/es/ttg-200x200.png", 150, LocalDate.of(2003, 2, 15));
		Usuario a3 = new Usuario("María", "Chávez", "https://tdj.gg/uploads/attachs/90430_66956401-BCC3-40B6-B951-32503B0895DE.png", 300, LocalDate.of(2001, 9, 18) );
		
		usuarioService.save(a1);
		usuarioService.save(a2);
		usuarioService.save(a3);
		
		Porra p1 = new Porra("Betis-Sevilla", "Descripción de porra", "Betis", "Sevilla");
		Porra p2 = new Porra("Madrid-Barça", "Descripción de porra", "Real Madrid", "FC Barcelona");
		Porra p3 = new Porra("Atletico de madrid-Celta de vigo", "Descripción de porra", "Atleti", "Celta de vigo");
		
		porraService.save(p1);
		porraService.save(p2);
		porraService.save(p3);
		
//	ApuestaUsuario aU1 = new ApuestaUsuario("X", 50, a1, p3);
//	
//	aUService.save(aU1);
	}
	
}
