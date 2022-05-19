package controlador.interfaces;

import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el controlador de datos de busqueda de los restos humanos
 * @autor Elías
 * Contiene métodos para obtener un identificador y los datos del resto humano mediante el código del resto.
 *
 */
public interface ContDatosBusqRH {
	public String obtenerIdentificado(String codResto);
	public RestoHumano obtenerRH(String codResto);
}
