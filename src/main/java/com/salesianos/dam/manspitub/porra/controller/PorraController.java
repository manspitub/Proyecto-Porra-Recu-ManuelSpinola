package com.salesianos.dam.manspitub.porra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianos.dam.manspitub.porra.model.Porra;
import com.salesianos.dam.manspitub.porra.repository.PorraRepository;
import com.salesianos.dam.manspitub.porra.service.PorraService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PorraController {
	
	@Autowired
	private PorraService pService;
	
	@Autowired
	private PorraRepository pRepo;
	
	
	@GetMapping("/porra")
	public String index(Model model) {
		List<Porra> porras = null;
		model.addAttribute("porras", porras);
		return "list-porras";
	}
	
}
