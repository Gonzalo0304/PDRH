package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa la ventana controlador de datos de restos humanos. Para asegurase de que se ejecutan los metodos independientemente de la base de datos utilizada
 * @author Equipo5
 */
public interface ContDatosRH {
	/**
	 * Da de alta los restos humanos 
	 * @param rh carga los datos de resto humano
	 * @throws Excepciones
	 */
	public void altaRH(RestoHumano rh) throws Excepciones;
	/**
	 * Modifica los restos humanos
	 * @param rh carga los datos de resto humano
	 * @throws Excepciones
	 */
	public void modificarRH(RestoHumano rh) throws Excepciones;
	/**
	 * Elimina los restos humanos.
	 * @param codResto carga el codigo de resto humano.
	 */
	public void eliminarRH(String codResto);
	/**
	 * Obtiene el resto humano cunado se solicita
	 * @param codResto carga el codigo de resto humano.
	 * @return devuelve un resto humano
	 */
	public RestoHumano obtenerRH(String codResto);
}
