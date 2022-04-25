package controlador;

import java.util.Map;

import modelo.clases.Caso;
import modelo.clases.Persona;

public interface ContDatosGestCaso {
	public void modificarCaso(Caso caso);
	public void eliminarCaso(Caso caso);
	public void agregarParticipante(String dni, Caso caso, String implicacion);
	public Map<String,Persona> listarParticipantes(String codCaso);
	public Map<String, Persona> listarPersonas();
}
