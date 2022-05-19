package controlador.interfaces;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de comparación de restos humanos.
 * @autor Elías
 * Contiene metodos para obtener al resto humano ya la persona
 * y tambien agregar un identificador.
 *
 */
public interface ContDatosCompEsp {
	/**
	 * Este metodo obtiene el resto humano
	 * @param codResto
	 * @return Devuelve los datos del resto humano.
	 */
	public RestoHumano obtenerRH(String codResto);
	/**
	 * Este metodo obtiene una persona especifica
	 * @param dni
	 * @return Devuelve los datos de esa persona.
	 */
	public Persona obtenerPersona(String dni);
	/**
	 * Este metodo agrega el identificado que hay entre 
	 * el codigo del resto humano y el dni de la persona.
	 * @param codResto
	 * @param dni
	 */
	public void agregarIdentificado(String codResto,String dni);
}
