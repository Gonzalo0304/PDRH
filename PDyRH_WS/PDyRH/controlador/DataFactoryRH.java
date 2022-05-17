package controlador;

import controlador.interfaces.ContDatosRH;
import modelo.ContBDImpleRH;

public class DataFactoryRH {
	private static ContDatosRH datos;
	
	public static synchronized ContDatosRH getDatos() {
		if (datos == null) {
			datos = new ContBDImpleRH();
		}
		return datos;
	}
}
