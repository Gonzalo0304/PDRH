package controlador;

import controlador.interfaces.ContDatosCompEsp;
import modelo.ContBDImpleCompEsp;

public class DataFactoryCompEsp {
	private static ContDatosCompEsp datos;
	
	public static synchronized ContDatosCompEsp getDatos() {
		if (datos == null) {
			datos = new ContBDImpleCompEsp();
		}
		return datos;
	}
}
