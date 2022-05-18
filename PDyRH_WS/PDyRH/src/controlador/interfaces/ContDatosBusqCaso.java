package controlador.interfaces;

import java.util.Map;

import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de la busqueda de casos
 * @author Elias
 * Contiene metodos para listar a los participantes del caso y los involucrados
 */
public interface ContDatosBusqCaso {
	public Map<String,Participante> listarParticipantes(String codCaso);
	public Map<String,RestoHumano> listarInvolucrados(String codCaso);
}
