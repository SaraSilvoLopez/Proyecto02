package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Juego
 *
 * @author Usoa Larrarte
 *
 * @date 24 jun. 2021
 * 
 * @version 2.0
 */

@Entity
@Table(name = "juegos")
public class Juego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "juego_id")
	private int id;
	private String nombre;
	private Integer fecha;
	private String editor;
	private String genero;
	private String plataforma;
	private Double ventas;
	
	/**
	 * Constructor de la clase Juego
	 *
	 */
	public Juego() {
	}

	/**
	 * Método getter del atributo id
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método setter del atributo id
	 *
	 * @param id to set id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método getter del atributo nombre
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre
	 *
	 * @param nombre to set nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo fecha
	 *
	 * @return fecha
	 */
	public Integer getFecha() {
		return fecha;
	}

	/**
	 * Método setter del atributo fecha
	 *
	 * @param fecha to set fecha 
	 */
	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método getter del atributo editor
	 *
	 * @return editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * Método setter del atributo editor
	 *
	 * @param editor to set editor 
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * Método getter del atributo genero
	 *
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Método setter del atributo genero
	 *
	 * @param genero to set genero 
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Método getter del atributo plataforma
	 *
	 * @return plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * Método setter del atributo plataforma
	 *
	 * @param plataforma to set plataforma 
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Método getter del atributo ventas
	 *
	 * @return ventas
	 */
	public Double getVentas() {
		return ventas;
	}

	/**
	 * Método setter del atributo ventas
	 *
	 * @param ventas to set ventas 
	 */
	public void setVentas(Double ventas) {
		this.ventas = ventas;
	}

	/**
	 * Sobrescritura del método toString
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", editor=" + editor + ", genero="
				+ genero + ", plataforma=" + plataforma + ", ventas=" + ventas + "]";
	}

}
