package controlador.interfaces;

import java.util.Map;

import modelo.clases.Conocido;
import modelo.clases.Persona;

/**
 * Esta interfaz representa el control de busqueda de personas
 * @author Elias
 * Contiene metodos para obtener a la persona y listar los conocidos de esa persona mediante el DNI.
 */
public interface ContDatosBusqPer {
	public Persona obtenerPersona(String dni);
	public Map<String,Conocido> listarConocidos(String dni1);
}
