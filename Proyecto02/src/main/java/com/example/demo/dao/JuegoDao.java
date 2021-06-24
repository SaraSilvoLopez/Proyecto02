package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

/**
 * @ClassName JuegoDao
 *
 * @author María Castro
 * @date 24 jun. 2021
 * 
 * @version 1.0
 */
@Repository
public interface JuegoDao extends JpaRepository<Juego, Integer> {

	@Query("FROM Juego WHERE genero='Platform'")
	List<Juego> findByGeneroPlataforma();

	@Query("SELECT DISTINCT editor FROM Juego")
	List<String> listaEditores();

	@Query("SELECT DISTINCT genero FROM Juego")
	List<String> listaGeneros();

	@Query("SELECT DISTINCT plataforma FROM Juego")
	List<String> listaPlataformas();
}
