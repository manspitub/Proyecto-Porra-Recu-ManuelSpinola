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
/**
 * Controlador de la apuesta usuario
 * @author MANSPITUB
 *
 */
public class ApuestaUsuarioController {
	private final ApuestaUsuarioService aUService;
	private final UsuarioService uService;
	private final PorraService pService;
	
	/**
	 * Se muestra la lista de usuarios
	 * @param model 
	 * @return lista de usuarios
	 */
	@GetMapping("/apuestaUsuario")
	public String index(Model model) {
		
		model.addAttribute("apuestasUsuario", aUService.findAll());
		return "list-apuestaUsuario";
	}
	/**
	 * Muestra el formulario para rellenar un usuario
	 * @param model
	 * @return formulario usuario
	 */
	@GetMapping("/apuestaUsuario/nuevo")
	public String nuevaApuestaUsuario (Model model) {
		model.addAttribute("apuestaUsuario", new ApuestaUsuario());
		return "form-apuestaUsuario";
	}
	/**
	 * Envía los datos de apuesta Usuario
	 * @param aUsuario
	 * @param model
	 * @param id
	 * @return
	 */
	@PostMapping("/apuestaUsuario/nuevo/submit")
	public String submitNuevaApuestaUsuario(@ModelAttribute("apuestaUsuario") ApuestaUsuario aUsuario, Model model, Long id) {
		/**
		 * Intento de método para mostrar mensaje cuando no haya usuarios registrados
		 */
		Optional<Usuario> user = uService.findById(id);
		if (user != null) {
			
		}else {
			model.addAttribute("no_usuario", false);
			model.addAttribute("mensaje", "No hay usuarios registrados");
			return "form-apuestaUsuario";
		}
		/**
		 * Método que comprueba si el usuario tiene saldo suficiente conforme al dinero apostado y devuelve error si tiene menos saldo
		 */
		if (aUsuario.getUsuario().getSaldo() < aUsuario.getDineroApostado()) {
			//no se puede hacer la apuesta
			// redireccionar al formulario de nuevo
			//return "redirect:/apuestaUsuario/nuevo";
			aUsuario.setDineroApostado(aUsuario.getUsuario().getSaldo());
			model.addAttribute("apuestaUsuario", aUsuario);
			model.addAttribute("error", true);
			model.addAttribute("mensaje_error", "Saldo insuficiente. La apuesta máxima debe ser inferior o igual a " + aUsuario.getUsuario().getSaldo());
			return "form-apuestaUsuario";
		} else {
			Usuario aEditar = aUsuario.getUsuario();
			aEditar.setSaldo(aEditar.getSaldo() - aUsuario.getDineroApostado());
			uService.edit(aEditar);
			aUService.save(aUsuario);
			
//			double total;
//			total = aUsuario.getDineroApostado();
//			model.addAttribute("recaudado", "El total recaudado es "+total);
			return "redirect:/apuestaUsuario";
		}
		
		
		
		
	}
	
	/**
	 * Edita un usuario
	 * @param id
	 * @param model
	 * @return la lista de usuarios modificada
	 */
	@GetMapping("apuestaUsuario/editar/{id}")
	public String editarApuestaUsuario(@PathVariable("id") Long id, Model model) {
		Optional<ApuestaUsuario> aUsuario = aUService.findById(id);
		
		if (aUsuario !=null) {
			model.addAttribute("apuestaUsuario", aUsuario);
			return "form-apuestaUsuario";
		}else {
			return "redirect:/index/";
		}
	
	}
	
	/**
	 * Borra un usuario
	 * @param id
	 * @param model
	 * @return Lista de apuesta usuario sin elemento borrado
	 */
	@GetMapping("/apuestaUsuario/borrar/{id}")
	public String borrarApuestaUsuario(@PathVariable("id") Long id, Model model) {
		aUService.deleteById(id);
		
		return "redirect:/apuestaUsuario/";
		
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
