package com.salesianos.dam.manspitub.porra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.dam.manspitub.porra.model.Usuario;

@Controller
public class UsuarioController {
	
	
	
	
	@GetMapping("/usuario")
	public String index(Model model) {
		//model.addAttribute("productos")
		return "form-usuario";
	}
	
	@GetMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		//model.addAttribute("porras")
		return "form-usuario";
	}
	
	@PostMapping("/usuario/nuevo/submit")
	public String submitNuevoUsuario(Usuario usuario, Model model) {
		return "redirect:/usuario/";
	}
}
