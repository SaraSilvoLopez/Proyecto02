package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.JuegoController;

import com.example.demo.service.JuegoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JuegoController.class)

public class Proyecto02_Test04_Delete {

	private static final int JUEGO_ID = 22;

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private JuegoService serv;

	@Test
	public void testDeleteByIdJuego() throws Exception {
		mockMvc.perform(get("/delete?id=" + JUEGO_ID)).andDo(print()).andExpect(status().is3xxRedirection());

	}

}