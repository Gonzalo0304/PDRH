package controlador;

import java.util.Map;

import modelo.clases.Persona;

public interface ContDatosInsertPer {
	public void altaPersona(Persona per);
	public Map<String, Persona> listarPersonas();
}
