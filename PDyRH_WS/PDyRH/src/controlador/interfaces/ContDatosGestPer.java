package controlador.interfaces;

import java.time.LocalDate;
import java.util.Map;

import excepciones.Excepciones;
import modelo.clases.Conocido;
import modelo.clases.Persona;

public interface ContDatosGestPer {
	public Persona obtenerPersona(String dni) ;
	public void modificarPersona(Persona per) throws Excepciones;
	public void eliminarPersona(String dni) ;
	public boolean comprobarDNI(String dni) ;
	public void agregarConocido(Conocido cono) throws Excepciones;
	public Map<String,Conocido> listarConocidos(String dni1) ;
	public void agregarFechaArresto(String dni, LocalDate fecha) throws Excepciones;
}
