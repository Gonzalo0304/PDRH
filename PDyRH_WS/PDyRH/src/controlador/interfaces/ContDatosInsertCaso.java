package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.Caso;

/**
 * Esta interfaz representa el controlador de insercion de los casos
 * @author Elias
 *
 */
public interface ContDatosInsertCaso {
	/**
	 * Este metodo se usa para dar de alta un caso
	 * @param caso
	 * @throws Excepciones: La excepcion lanza un mensaje de aviso.
	 */
	public void altaCaso(Caso caso) throws Excepciones;
	/**
	 * Este comprueba si el codigo del caso existe
	 * @param codCaso
	 * @return <true>El codigo del caso</true> <false>El dni no existe</false> 
	 */
	public boolean comprobarCodCaso(String codCaso);
}
