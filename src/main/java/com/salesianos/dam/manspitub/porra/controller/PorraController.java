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

import com.salesianos.dam.manspitub.porra.model.Porra;
import com.salesianos.dam.manspitub.porra.repository.PorraRepository;
import com.salesianos.dam.manspitub.porra.service.PorraService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/**
 * Controlador de Porra
 * @author MANSPITUB
 *
 */
public class PorraController {
	
	@Autowired
	private PorraService pService;
	
	@Autowired
	private PorraRepository pRepo;
	
	/**
	 * Lista de porras
	 * @param model
	 * @return
	 */
	@GetMapping("/porra")
	public String index(Model model) {
		
		model.addAttribute("porras", pService.findAll());
		return "list-porra";
	}
	/**
	 *Formulario de porra 
	 * @param model
	 * @return
	 */
	@GetMapping("/porra/nuevo")
	public String nuevaPorra(Model model) {
		model.addAttribute("porra", new Porra());
		
		return "form-porra";
	}
	/**
	 * Envío datos de porra
	 * @param porra
	 * @param model
	 * @return
	 */
	@PostMapping("/porra/nuevo/submit")
	public String submitNuevaPorra(@ModelAttribute("porra") Porra porra, Model model) {
		pService.save(porra);
		return "redirect:/porra";
	}
	
	/**
	 * Edición de una porra
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("porra/editar/{id}")
	public String editarPorra(@PathVariable("id") Long id, Model model) {
		Optional<Porra> porra = pService.findById(id);
		
		if (porra !=null) {
			model.addAttribute("porra", porra);
			return "form-porra";
		}else {
			return "redirect:/porra/";
		}
	}
	/**
	 * Borrado de una porra
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/porra/borrar/{id}")
	public String borrarUsuario(@PathVariable("id") Long id, Model model) {
		pService.deleteById(id);
		
		return "redirect:/porra/";
		
	}
	
	
	
	
	
}
