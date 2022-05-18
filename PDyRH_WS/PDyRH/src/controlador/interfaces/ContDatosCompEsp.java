package controlador.interfaces;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de comparacion de restos humanos. 
 * @author Elias
 * Contiene metodos para obtener al resto humano y a las persona
 * y tambien agregar a un identificado.
 */
public interface ContDatosCompEsp {
	public RestoHumano obtenerRH(String codResto);
	public Persona obtenerPersona(String dni);
	public void agregarIdentificado(String codResto,String dni);
}
