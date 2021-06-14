package com.salesianos.dam.manspitub.porra.controller;

import java.util.ArrayList;
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
		
		Porra p1 = new Porra("Betis-Sevilla", "Descripción de porra", "Betis", "Sevilla");
		Porra p2 = new Porra("Madrid-Barça", "Descripción de porra", "Real Madrid", "FC Barcelona");
		Porra p3 = new Porra("Atletico de madrid-Celta de vigo", "Descripción de porra", "Atleti", "Celta de vigo");
		
		List<Porra> porras = new ArrayList<Porra>();
		
		porras.add(p1);
		porras.add(p2);
		porras.add(p3);
		
		model.addAttribute("porras", porras);
		return "list-porra";
	}
	
	
	
}
