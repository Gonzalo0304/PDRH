package controlador.interfaces;

import java.util.Map;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de  comparacion
 * @author Elias
 * Contiene metodos para listar a los restos humanos y las personas desaparecidas
 * y obtener al identificado.
 */
public interface ContDatosComp {
	public Map<String,RestoHumano> listarRHs();
	public Map<String,Persona> listarDesaparecidas();
	public String obtenerIdentificado(String codResto);
}
