package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.Persona;

/**
 * Esta clase interfaz representa el controlador de insercion de personas
 * @author Elias
 *
 */
public interface ContDatosInsertPer {
	/**
	 * Este metodo inserta los datos de la clase Persona
	 * @param per
	 * @throws Excepciones: la excepcion lanza un mensaje de aviso. 
	 */
	public void altaPersona(Persona per) throws Excepciones;
	/**
	 * Este metodo comprueba que si el dni existe
	 * @param dni
	 * @return <true>El dni existe</true> <false>El dni no existe</false> 
	 */
	public boolean comprobarDNI(String dni);
}
