package controlador.interfaces;

import modelo.clases.Caso;

/**
 * Esta interfaz representa el controlador de busqueda
 * @autor Elías
 * Contiene métodos para encontrar personas, restos humanos y casos.
 *
 */
public interface ContDatosBusq {
	/**
	 * Este metodo comprueba que si el dni existe
	 * @param dni
	 * @return <true>El dni existe</true> <false>El dni no existe</false> 
	 */
	public boolean comprobarDNI(String dni);

	/**
	 * 	Este metodo comprueba que el codigo del caso existe
	 * @param codResto
	 * @return <true>El codigo existe</true> <false>El codigo no existe</false> 
	 */
	public boolean comprobarCodResto(String codResto);
	/**
	 * Este metodo obtiene los datos del caso
	 * @param codCaso
	 * @return Devuelve los datos del caso encontrado.
	 */
	public Caso obtenerCaso(String codCaso);
}
