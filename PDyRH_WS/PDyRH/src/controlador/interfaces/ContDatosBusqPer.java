package controlador.interfaces;

import java.util.Map;

import modelo.clases.Conocido;
import modelo.clases.Persona;

public interface ContDatosBusqPer {
	public Persona obtenerPersona(String dni) ;
	public Map<String,Conocido> listarConocidos(String dni1) ;
}
