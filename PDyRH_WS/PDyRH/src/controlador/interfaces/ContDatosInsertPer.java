package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.Persona;

public interface ContDatosInsertPer {
	public void altaPersona(Persona per) throws Excepciones;
	public boolean comprobarDNI(String dni);
}
