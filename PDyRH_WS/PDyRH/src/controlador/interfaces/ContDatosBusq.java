package controlador.interfaces;

import modelo.clases.Caso;

/**
 * Esta interfaz representa el controlador de busqueda
 * @author Elias
 * Contiene metodos para encontrar personas, restos humanos y casos.
 */
public interface ContDatosBusq {
	public boolean comprobarDNI(String dni);
	public boolean comprobarCodResto(String codResto);
	public Caso obtenerCaso(String codCaso);
}
