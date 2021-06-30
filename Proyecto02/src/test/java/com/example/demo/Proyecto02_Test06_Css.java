package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(JuegoController.class)

public class Proyecto02_Test06_Css {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() throws Exception {
		mockMvc.perform(get("/css/styles.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	public void contextLoads1() throws Exception {
		mockMvc.perform(get("/css/style.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
}
