package com.salesianos.dam.manspitub.porra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.salesianos.dam.manspitub.porra.model.ApuestaUsuario;
import com.salesianos.dam.manspitub.porra.model.Porra;
import com.salesianos.dam.manspitub.porra.model.Usuario;
import com.salesianos.dam.manspitub.porra.service.ApuestaUsuarioService;
import com.salesianos.dam.manspitub.porra.service.PorraService;
import com.salesianos.dam.manspitub.porra.service.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ApuestaUsuarioController {
	private final ApuestaUsuarioService aUService;
	private final UsuarioService uService;
	private final PorraService pService;
	
	@GetMapping("/apuestaUsuario")
	public String index(Model model) {
		
		model.addAttribute("apuestasUsuario", aUService.findAll());
		return "list-apuestaUsuario";
	}
	
	@GetMapping("/apuestaUsuario/nuevo")
	public String nuevaApuestaUsuario (Model model) {
		model.addAttribute("apuestaUsuario", new ApuestaUsuario());
		return "form-apuestaUsuario";
	}
	
	
	@ModelAttribute("tipos_resultados")
	public List<String> tiposResultados() {
		return ApuestaUsuario.tipos_resultados();
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> usuarios() {
		return uService.findAll();
	}
	
	@ModelAttribute("porras")
	public List<Porra> porras() {
		return pService.findAll();
	}
}
