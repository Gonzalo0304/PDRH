package controlador.interfaces;

import excepciones.Excepciones;
import modelo.clases.RestoHumano;

public interface ContDatosRH {
	public void altaRH(RestoHumano rh) throws Excepciones;
	public void modificarRH(RestoHumano rh) throws Excepciones;
	public void eliminarRH(String codResto);
	public RestoHumano obtenerRH(String codResto);
}
