package controlador.interfaces;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ContDatosCompEsp {
	public RestoHumano obtenerRH(String codResto);
	public Persona obtenerPersona(String dni);
	public void agregarIdentificado(String codResto,String dni);
}
