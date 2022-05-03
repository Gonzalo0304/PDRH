package controlador.interfaces;

import modelo.clases.RestoHumano;

public interface ContDatosRH {
	public void altaRH(RestoHumano rh);
	public void modificarRH(RestoHumano rh);
	public void eliminarRH(String codResto);
	public RestoHumano obtenerRH(String codResto);
}
