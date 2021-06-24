package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Juego> findByGeneroPlataforma(){
		return juegoDAO.findByGeneroPlataforma();
	}

}
