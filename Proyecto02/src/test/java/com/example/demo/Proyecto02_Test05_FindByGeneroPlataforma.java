package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dao.JuegoDao;
import com.example.demo.service.JuegoService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Proyecto02_Test05_FindByGeneroPlataforma {

	@MockBean
    private JuegoDao juegoDao;
 
    @Autowired
    private JuegoService juegoService;
 
    @Test
    public void test() {

        when(juegoDao.findByGeneroPlataforma()).thenReturn(new ArrayList<>());
        assertThat(juegoService.findByGeneroPlataforma()).isEmpty();
        verify(juegoDao, times(1)).findByGeneroPlataforma();
    }
}
