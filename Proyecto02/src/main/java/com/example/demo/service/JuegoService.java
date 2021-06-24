package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Juego;

/**
 * @ClassName JuegoService
 *
 * @author María Castro
 *
 * @date 24 jun. 2021
 * 
 * @version 1.0
 */
public interface JuegoService {

	// Para modificar y añadir juego
	public void save(Juego juego);

	// Para recuperar un juego y poder modificarlo
	public Juego getById(int id);

	// Para eliminar juego por id
	public void deleteById(int id);

	// Para listar todos los juegos
	public List<Juego> findAll();

	// Metodo propio para listar juegos de genero = plataforma
	public List<Juego> findByGeneroPlataforma();

	// Metodo propio para lista de editores
	public List<String> listaEditores();

	// Metodo propio para lista de generos
	public List<String> listaGeneros();

	// Metodo propio para lista de plataformas
	public List<String> listaPlataformas();

	// Para guardar todo
	public void saveAll(List<Juego> listaJuegos);

}
