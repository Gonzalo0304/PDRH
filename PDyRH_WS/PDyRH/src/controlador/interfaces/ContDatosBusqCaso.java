package controlador.interfaces;

import java.util.Map;

import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de la busqueda de casos
 * @autor Equipo5
 * Contiene métodos para listar a los participantes del caso y los involucrados
 *
 */
public interface ContDatosBusqCaso {
	/**
	 * Este metodo lista los participantes del caso
	 * @param codCaso
	 * @return Devuelve los datos del participante
	 */
	public Map<String,Participante> listarParticipantes(String codCaso);
	/**
	 * Esta metodo lista los involucrados del caso
	 * @param codCaso
	 * @return Devuelve los datos del Resto Humano que se encuentra en el caso.
	 */
	public Map<String,RestoHumano> listarInvolucrados(String codCaso);
}
