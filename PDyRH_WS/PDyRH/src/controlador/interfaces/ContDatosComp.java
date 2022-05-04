package controlador.interfaces;

import java.util.Map;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ContDatosComp {
	public Map<String,RestoHumano> obtenerRHs();
	public Map<String,Persona> obtenerDesaparecidas();
	public String obtenerIdentificado(String codResto);
}
