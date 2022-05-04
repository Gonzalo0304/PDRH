package controlador.interfaces;

import java.util.Map;

import modelo.clases.Persona;

public interface ContDatosBusqRap {
	public Map<String,Persona> obtenerPersonas(String nombre);
}
