package controlador.interfaces;

import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el controlador de datos de busqueda de los restos humanos
 * @autor El�as
 * Contiene m�todos para obtener un identificador y los datos del resto humano mediante el c�digo del resto.
 *
 */
public interface ContDatosBusqRH {
	/**
	 * Este metodo obtiene el resto humano identificado
	 * @param codResto
	 * @return Devuelve la identificacion
	 */
	public String obtenerIdentificado(String codResto);
	/**
	 * Este metodo obtiene el resto humano
	 * @param codResto
	 * @return Devuelve los datos del resto humano.
	 */
	public RestoHumano obtenerRH(String codResto);
}
