package controlador.interfaces;

import java.time.LocalDate;
import java.util.Map;

import modelo.clases.Conocido;
import modelo.clases.Persona;

public interface ContDatosGestPer {
	public Persona obtenerPersona(String dni);
	public void modificarPersona(Persona per);
	public void eliminarPersona(String dni);
	public boolean comprobarDNI(String dni);
	public void agregarConocido(Conocido cono);
	public Map<String,Conocido> listarConocidos(String dni1);
	public void agregarFechaArresto(String dni, LocalDate fecha);
}
