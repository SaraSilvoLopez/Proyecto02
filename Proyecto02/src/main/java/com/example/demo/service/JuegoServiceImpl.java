package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JuegoDao;
import com.example.demo.model.Juego;

/**
 * @ClassName JuegoServiceImpl
 *
 * @author María Castro
 *
 * @date 24 jun. 2021
 * 
 * @version 1.0
 */
@Service
public class JuegoServiceImpl implements JuegoService {

	/**
	 * Instancio juegoDAO. Inyeccion dependencia
	 */
	@Autowired
	JuegoDao juegoDAO;

	/**
	 * Implementación/Sobrescritura del método save
	 *
	 * @param juego
	 */
	@Override
	public void save(Juego juego) {
		juegoDAO.save(juego);
	}

	/**
	 * Implementación/Sobrescritura del método getById
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Juego getById(int id) {
		return juegoDAO.getById(id);
	}

	/**
	 * Implementación/Sobrescritura del método deleteById
	 *
	 * @param id
	 */
	@Override
	public void deleteById(int id) {
		juegoDAO.deleteById(id);
	}

	/**
	 * Implementación/Sobrescritura del método findAll
	 *
	 * @return
	 */
	@Override
	public List<Juego> findAll() {
		return juegoDAO.findAll();
	}

	/**
	 * Implementación/Sobrescritura del método findByGeneroPlataforma
	 *
	 * @return
	 */
	@Override
	public List<Juego> findByGeneroPlataforma() {
		return juegoDAO.findByGeneroPlataforma();
	}

	/**
	 * Implementación/Sobrescritura del método listaEditores
	 *
	 * @return
	 */
	@Override
	public List<String> listaEditores() {
		return juegoDAO.listaEditores();
	}

	/**
	 * Implementación/Sobrescritura del método listaGeneros
	 *
	 * @return
	 */
	@Override
	public List<String> listaGeneros() {
		return juegoDAO.listaGeneros();
	}

	/**
	 * Implementación/Sobrescritura del método listaPlataformas
	 *
	 * @return
	 */
	@Override
	public List<String> listaPlataformas() {
		return juegoDAO.listaPlataformas();
	}

	/**
	 * Implementación/Sobrescritura del método saveAll
	 *
	 * @param List<Juego> listaJuegos
	 */
	@Override
	public void saveAll(List<Juego> listaJuegos) {
		juegoDAO.saveAll(listaJuegos);
	}
	
	/**
	 * Implementación/Sobrescritura del método getAll
	 *
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Juego> getAll(Pageable pageable) {
		return juegoDAO.findAll(pageable);
	}

}
