package controlador.interfaces;

import modelo.clases.Caso;

public interface ContDatosBusq {
	public boolean comprobarDNI(String dni);
	public boolean buscarRH(String codResto);
	public Caso buscarCaso(String codCaso);
}
