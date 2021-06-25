package com.example.demo.controller;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Juego;
import com.example.demo.service.JuegoService;
import com.example.demo.utilities.LeerFichero;

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
	public String newJuego(Juego juego, Model m) {
		log.info("----- Dentro de newJuego");
		m.addAttribute("listaEditores", service.listaEditores());
		m.addAttribute("listaGeneros", service.listaGeneros());
		m.addAttribute("listaPlataformas", service.listaPlataformas());
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
	public String listJuego(@RequestParam Map<String, Object> params, Model m) {
		log.info("----- Dentro de listJuego");
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		PageRequest pageRequest = PageRequest.of(page,  10);
		Page<Juego> pagePersona = service.getAll(pageRequest);
		int totalPage = pagePersona.getTotalPages();
		if(totalPage>0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			m.addAttribute("pages", pages);
		}
		m.addAttribute("juegoList", pagePersona.getContent());
		m.addAttribute("current", page +1);
		m.addAttribute("next", page +2);
		m.addAttribute("prev", page);
		m.addAttribute("last", totalPage);
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
		m.addAttribute("listaEditores", service.listaEditores());
		m.addAttribute("listaGeneros", service.listaGeneros());
		m.addAttribute("listaPlataformas", service.listaPlataformas());
		
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
	* @param m
	* @return new ModelAndView
	*/
	@GetMapping("/cargafichero")
	public ModelAndView cargaFichero(Model m) {
		log.info("----- Dentro de cargaFichero");
		service.saveAll(LeerFichero.leerDatosFichero());
		return new ModelAndView("redirect:/");
	}

	/**
	 * 
	 * 
	 * @return JuegoList
	 */
	@GetMapping("/listGeneroPlataforma")
	public String listGeneroPlataforma(Model m) {
		log.info("----- Dentro de findByGeneroPlataforma");
		m.addAttribute("juegoList", service.findByGeneroPlataforma());
		//return "JuegoListGeneroPlataforma";
		return "JuegoListGeneroPlataforma";
	}
}
