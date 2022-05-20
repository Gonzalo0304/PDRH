package controlador.interfaces;

import java.util.Map;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de comparación
 * @autor Equipo5
 * Contiene métodos para enumerar los restos humanos y las personas desaparecidas
 * y obtener al identificado.
 *
 */
public interface ContDatosComp {
	/**
	 * Esta metodo lista los restos humanos que se encuentran en la clase
	 * @return Devuelve los datos de los restos humanos.
	 */
	public Map<String,RestoHumano> listarRHs();
	/**
	 * Este metodo lista a las personas desaparecidas
	 * @return Devuelve los datos de las personas desaparecidas.
	 */
	public Map<String,Persona> listarDesaparecidas();
	/**
	 * Este metodo obtiene el resto humano identificado
	 * @param codResto
	 * @return Devuelve la identificacion
	 */
	public String obtenerIdentificado(String codResto);
}
