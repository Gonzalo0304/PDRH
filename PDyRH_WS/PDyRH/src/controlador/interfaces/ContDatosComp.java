package controlador.interfaces;

import java.util.Map;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ContDatosComp {
	public Map<String,RestoHumano> listarRHs() ;
	public Map<String,Persona> listarDesaparecidas() ;
	public String obtenerIdentificado(String codResto) ;
}
