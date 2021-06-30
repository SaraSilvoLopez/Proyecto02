package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Juego;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Proyecto02_Test08_NewJuego {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		
		Juego juego = new Juego();
		juego.setNombre("Grupo02");
		juego.setEditor("Desconocido");
		juego.setGenero("Desconocido");
		juego.setPlataforma("Desconocido");
		juego.setFecha(2020);
		juego.setVentas(1.0);
		
		mockMvc.perform(get("/new").requestAttr("juego", juego))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().string(containsString("Guarda")));
	}
}
