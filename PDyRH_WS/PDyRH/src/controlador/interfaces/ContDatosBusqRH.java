package controlador.interfaces;

import modelo.clases.RestoHumano;

public interface ContDatosBusqRH {
	public String obtenerIdentificado(String codResto) ;
	public RestoHumano obtenerRH(String codResto) ;
}
