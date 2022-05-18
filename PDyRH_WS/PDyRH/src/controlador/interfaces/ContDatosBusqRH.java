package controlador.interfaces;

import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el controlador de datos de busqueda de los restos humanos
 * @author Elias
 * Contiene metodos obtener un identificado y los datos del resto humano mediante el codigo del resto.
 */
public interface ContDatosBusqRH {
	public String obtenerIdentificado(String codResto);
	public RestoHumano obtenerRH(String codResto);
}
