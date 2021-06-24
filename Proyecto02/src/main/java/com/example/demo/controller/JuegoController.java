package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Juego;
import com.example.demo.service.JuegoService;

/**
 * @ClassName JuegoController
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 24 jun. 2021
 * 
 * @version 2.0
 */
@Controller
public class JuegoController {
	
	/**
	 * Instancia servicios
	 */
	@Autowired
	JuegoService service;
	
	/**
	 * Atributo log
	 */
	private static final Logger log = LoggerFactory.getLogger(JuegoController.class);
	
	/**
	 * 
	 * 
	 * @param juego
	 * @return JuegoForm 
	 */
	@GetMapping("/new")
	public String newJuego(Juego juego) {
		log.info("----- Dentro de newJuego");
		return "JuegoForm";
	}
	
	/**
	 * 
	 * 
	 * @param juego
	 * @return new ModelAndView
	 */
	@PostMapping("/save")
	public ModelAndView saveJuego(Juego juego) {
		log.info("----- Dentro de saveJuego");
		service.save(juego);
		return new ModelAndView("redirect:/");
	}

	/**
	 * 
	 * 
	 * @param m
	 * @return JuegoList
	 */
	@GetMapping("/")
	public String listJuego(Model m) {
		log.info("----- Dentro de listJuego");
		m.addAttribute("juegoList", service.findAll());
		return "JuegoList";
	}
	
	/**
	 * 
	 * 
	 * @param id
	 * @param m
	 * @return JuegoForm
	 */
	@GetMapping("/edit")
	public String editJuego(@RequestParam("id") int id, Model m) {
		log.info("----- Dentro de editJuego");
		m.addAttribute("juego", service.getById(id));
		return "JuegoForm";
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return redirect
	 */
	@GetMapping("/delete")
	public String deleteJuego(@RequestParam("id") int id) {
		log.info("----- Dentro de deleteJuego");
		service.deleteById(id);
		return ("redirect:/");
	}

	/**
	 * 
	 * 
	 * @return JuegoList
	 */
	@GetMapping("/listGeneroPlataforma")
	public String listGeneroPlataforma() {
		log.info("----- Dentro de findByGeneroPlataforma");
		service.findByGeneroPlataforma();
		return "JuegoListGeneroPlataforma";
	}
}