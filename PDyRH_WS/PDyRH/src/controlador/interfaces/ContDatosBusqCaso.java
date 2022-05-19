package controlador.interfaces;

import java.util.Map;

import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public interface ContDatosBusqCaso {
	public Map<String,Participante> listarParticipantes(String codCaso) ;
	public Map<String,RestoHumano> listarInvolucrados(String codCaso) ;
}
