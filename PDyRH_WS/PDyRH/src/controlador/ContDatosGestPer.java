package controlador;

import java.time.LocalDate;
import java.util.Map;

import modelo.clases.Persona;

public interface ContDatosGestPer {
	public void modificarPersona(Persona per);
	public void eliminarPersona(Persona per);
	public Map<String, Persona> listarPersonas();
	public void agregarConocido(Persona per, String dni2, String relacion);
	public Map<String,Persona> listarConocidos(String dni1);
	public void agregarFechaArresto(String dni, LocalDate fecha);
}
