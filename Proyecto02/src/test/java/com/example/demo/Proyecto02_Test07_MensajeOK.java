package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Proyecto02_Test07_MensajeOK {
	
	@LocalServerPort
	private int port;
		
	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	void contextLoads() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Mario");
	}
	
}
