package controlador.interfaces;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de comparación de restos humanos.
 * @autor Elías
 * Contiene metodos para obtener al resto humano ya la persona
 * y tambien agregar un identificador.
 *
 */
public interface ContDatosCompEsp {
	public RestoHumano obtenerRH(String codResto);
	public Persona obtenerPersona(String dni);
	public void agregarIdentificado(String codResto,String dni);
}
