package controlador.interfaces;

import java.util.Map;

import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public interface ContDatosGestCaso {
	public void modificarCaso(Caso caso);
	public void eliminarCaso(String codCaso);
	public void insertarParticipante(Participante par);
	public void insertarInvolucrado(String codResto, String codCaso);
	public Map<String,Participante> listarParticipantes(String codCaso);
	public boolean comprobarDNI(String dni);
	public boolean buscarRH(String codResto);
	public Map<String,RestoHumano> listarInvolucrados(String codCaso);
}
