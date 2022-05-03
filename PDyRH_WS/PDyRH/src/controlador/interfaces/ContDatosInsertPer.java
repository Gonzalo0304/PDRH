package controlador.interfaces;

import modelo.clases.Persona;

public interface ContDatosInsertPer {
	public void altaPersona(Persona per);
	public boolean comprobarDNI(String dni);
}
