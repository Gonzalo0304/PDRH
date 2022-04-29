package controlador;

import modelo.clases.Caso;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ContDatosBusq {
	public Persona buscarPersona(String dni);
	public RestoHumano buscarRH(String codResto);
	public Persona buscarIdentificado(String codResto);
	public Caso buscarCaso(String codCaso);
}
