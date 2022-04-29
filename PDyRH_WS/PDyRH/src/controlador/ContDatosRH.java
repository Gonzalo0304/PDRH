package controlador;

import java.util.Map;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ContDatosRH {
	public void altaRH(RestoHumano rh);
	public void modificarRH(RestoHumano rh);
	public void eliminarRH(RestoHumano rh);
	public Map<String, RestoHumano> listarRestos();
	
	public void agregarIdentificado(RestoHumano resto, Persona per);
}
