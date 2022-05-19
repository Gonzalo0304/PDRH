package controlador.interfaces;

import java.util.Map;

import modelo.clases.Conocido;
import modelo.clases.Persona;

/**
 * Esta interfaz representa el control de busqueda de personas
 * @autor Elías
 * Contiene métodos para obtener a la persona y listar los conocidos de esa persona mediante el DNI.
 *
 */
public interface ContDatosBusqPer {
	/**
	 * Este metodo obtiene una persona especifica
	 * @param dni
	 * @return Devuelve los datos de esa persona.
	 */
	public Persona obtenerPersona(String dni);
	/**
	 * Este metodo lista los conocidos de la persona
	 * @param dni1
	 * @return Devuelve los datos del conocido.
	 */
	public Map<String,Conocido> listarConocidos(String dni1);
}
