package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.Caso;

public interface ContDatosInsertCaso {
	public void altaCaso(Caso caso) throws Excepciones;
	public boolean comprobarCodCaso(String codCaso);
}
