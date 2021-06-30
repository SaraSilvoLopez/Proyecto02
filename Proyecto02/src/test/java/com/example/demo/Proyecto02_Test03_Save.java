package com.example.demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.example.demo.model.Juego;


@ExtendWith(SpringExtension.class)
//@WebMvcTest(JuegoController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Proyecto02_Test03_Save {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {

		Juego juego = new Juego();
		juego.setNombre("Grupo02");
		

		mockMvc.perform(post("/save").requestAttr("juego", juego))
			.andDo(print())
			.andExpect(status().is3xxRedirection());
			//.andExpect(content().string(containsString("LISTADO JUEGOS")));
	}

}
