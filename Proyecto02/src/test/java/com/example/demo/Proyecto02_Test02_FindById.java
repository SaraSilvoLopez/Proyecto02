package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.JuegoController;
import com.example.demo.model.Juego;
import com.example.demo.service.JuegoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JuegoController.class)

public class Proyecto02_Test02_FindById {

	private static final int JUEGO_ID = 2;

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private JuegoService serv;

	@Test
	public void testGetJuego() throws Exception {
		Juego juego = new Juego();
		juego.setNombre("Grupo02");
		Mockito.when(serv.getById(JUEGO_ID)).thenReturn(juego);
				mockMvc.perform(get("/edit?id=" + JUEGO_ID))
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(content().string(containsString("Grupo02")));
				
				
	}

}