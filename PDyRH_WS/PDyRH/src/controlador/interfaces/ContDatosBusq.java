package controlador.interfaces;

import modelo.clases.Caso;

public interface ContDatosBusq {
	public boolean comprobarDNI(String dni);
	public boolean comprobarCodResto(String codResto) ;
	public Caso obtenerCaso(String codCaso) ;
}
