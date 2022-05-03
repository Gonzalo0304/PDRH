package controlador.interfaces;

import modelo.clases.Caso;

public interface ContDatosInsertCaso {
	public void altaCaso(Caso caso);
	public boolean comprobarCodCaso(String codCaso);
}
