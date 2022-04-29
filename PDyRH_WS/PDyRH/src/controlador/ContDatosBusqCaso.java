package controlador;

import java.util.Map;

import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public interface ContDatosBusqCaso {
	public Map<String,Participante> participantes(String codCaso);
	public Map<String,RestoHumano> restos(String codCaso);
}
