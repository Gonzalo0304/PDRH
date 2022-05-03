package controlador;

import java.util.Map;

import modelo.clases.Caso;

public interface ContDatosInsertCaso {
	public void altaCaso(Caso caso);
	public Map<String, Caso> listarCasos();
}
