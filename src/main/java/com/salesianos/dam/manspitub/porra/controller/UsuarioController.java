package com.salesianos.dam.manspitub.porra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.dam.manspitub.porra.model.Usuario;
import com.salesianos.dam.manspitub.porra.repository.UsuarioRepository;
import com.salesianos.dam.manspitub.porra.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsuarioController {
	
	@Autowired
	private UsuarioService uService;
	
	@Autowired
	private UsuarioRepository uRepo;
	
	
	
	@GetMapping("/usuario")
	public String index(Model model) {
		
		Usuario a1 = new Usuario("Manuel", "Spinola Tubio" , "https://tdj.gg/uploads/attachs/20560_w9RC4W-QqXw-200x200.jpg" , 200);
		Usuario a2 = new Usuario("Pepe", "Perez", 150);
		Usuario a3 = new Usuario("María", "Chávez", "https://tdj.gg/uploads/attachs/90430_66956401-BCC3-40B6-B951-32503B0895DE.png", 300);
		
		List<Usuario> usuarios= new ArrayList <Usuario>();
		
		usuarios.add(a1);
		usuarios.add(a2);
		usuarios.add(a3);
		
		
		model.addAttribute("usuarios",  usuarios);
		return "list-usuario";
	}
	
	@GetMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		//model.addAttribute("porras")
		return "form-usuario";
	}
	
	@PostMapping("/usuario/nuevo/submit")
	public String submitNuevoUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		uService.save(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("usuario/editar/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {
		Optional<Usuario> usuario = uService.findById(id);
		
		if (usuario !=null) {
			model.addAttribute("usuario", usuario);
			return "form-usuario";
		}else {
			return "redirect:/index/";
		}
	
		
	}
	
	@GetMapping("/usuario/{id}")
	public String unUsuario(@PathVariable("id") Long usuarioId, Model model) {
		Usuario u = uService.findById(usuarioId).orElse(null);
		model.addAttribute("usuario", u);
		
		return "detailUsuario";
	}
	
	
	
	
	
}
