package controlador.interfaces;

import java.time.LocalDate;
import java.util.Map;

import excepciones.Excepciones;
import modelo.clases.Conocido;
import modelo.clases.Persona;

/**
 * Esta interfaz representa el control de la gestion de las personas
 * @author Equipo5
 *
 */
public interface ContDatosGestPer {
	/**
	 * Este metodo obtiene una persona especifica
	 * @param dni
	 * @return Devuelve los datos de esa persona.
	 */
	public Persona obtenerPersona(String dni);
	/**
	 * Este metodo modifica a la persona
	 * @param per
	 * @throws Excepciones: La excepcion lanza un mensaje de aviso.
	 */
	public void modificarPersona(Persona per) throws Excepciones;
	/**
	 * Este metodo elimina a una persona especifica
	 * @param dni
	 */
	public void eliminarPersona(String dni);
	/**
	 * Este metodo comprueba que si el dni existe
	 * @param dni
	 * @return <true>El dni existe</true> <false>El dni no existe</false> 
	 */
	public boolean comprobarDNI(String dni);
	/**
	 * Este metodo insertar el conocido de la persona
	 * @param cono
	 * @throws Excepciones: La excepcion lanza un mensaje de aviso.
	 */
	public void agregarConocido(Conocido cono) throws Excepciones;
	/**
	 * 
	 * Este metodo lista los conocidos de la persona
	 * @param dni1
	 * @return Devuelve los datos del conocido.
	 */
	public Map<String,Conocido> listarConocidos(String dni1);
	/**
	 * Este metodo inserta las fechas de arresto del criminal
	 * @param dni
	 * @param fecha
	 * @throws Excepciones:La excepcion lanza un mensaje de aviso.
	 */
	public void agregarFechaArresto(String dni, LocalDate fecha) throws Excepciones;
}
