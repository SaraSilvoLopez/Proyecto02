package com.example.demo.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Juego;

/**
 * @ClassName LeerFichero
 *
 * @author Jennifer Pérez modificado por Usoa Larrarte
 *
 * @date 24 jun. 2021
 * 
 * @version 2.0
 */

public class LeerFichero {

	/**
	 * Atributo RUTAFICHERO
	 */
	private static final String RUTAFICHERO = "ficheroJuegos.csv";

	/**
	 * Método de lectura de datos desde fichero
	 * 
	 * @return listaJuegos
	 */
	public static List<Juego> leerDatosFichero() {

		List<Juego> listaJuegos = new ArrayList<>();

		File archivo = new File(RUTAFICHERO);
		FileReader fr = null;

		try {
			fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] juegoString = linea.split(";");
				if (!juegoString[0].equals("Rank")) {
					Juego juego = arrayToJuegos(juegoString);
					listaJuegos.add(juego);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepción.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listaJuegos;
	}

	/**
	 * Guarda en un array cada juego, nombre en la 1, plataforma en la 2, fecha en
	 * la 3, genero en la 4, editor en la 5 y ventas de Europa en la 6.
	 * 
	 * @param juegoString array tipo String: incluye los datos completos de un juego
	 * @return juego
	 */
	public static Juego arrayToJuegos(String[] juegoString) {

		String nombre = String.valueOf(juegoString[1]);
		String plataforma = String.valueOf(juegoString[2]);
		Integer fecha = Integer.valueOf(juegoString[3]);
		String genero = String.valueOf(juegoString[4]);
		String editor = String.valueOf(juegoString[5]);
		Double ventas = Double.valueOf(juegoString[6]);

		Juego juego = new Juego();
		juego.setNombre(nombre);
		juego.setPlataforma(plataforma);
		juego.setFecha(fecha);
		juego.setGenero(genero);
		juego.setEditor(editor);
		juego.setVentas(ventas);

		return juego;
	}

}
