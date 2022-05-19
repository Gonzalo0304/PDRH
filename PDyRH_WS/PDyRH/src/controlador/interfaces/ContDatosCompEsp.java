package controlador.interfaces;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de comparaci�n de restos humanos.
 * @autor El�as
 * Contiene metodos para obtener al resto humano ya la persona
 * y tambien agregar un identificador.
 *
 */
public interface ContDatosCompEsp {
	public RestoHumano obtenerRH(String codResto);
	public Persona obtenerPersona(String dni);
	public void agregarIdentificado(String codResto,String dni);
}
