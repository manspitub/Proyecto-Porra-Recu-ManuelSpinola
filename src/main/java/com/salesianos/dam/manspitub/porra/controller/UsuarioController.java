package com.salesianos.dam.manspitub.porra.controller;

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
		
		List<Usuario> usuarios = null;
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
	public String submitNuevoUsuario(@ModelAttribute("form-usuario") Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "list-usuario";
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
	
	
	
}
