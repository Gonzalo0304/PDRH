package controlador;

import controlador.interfaces.ContDatosCompEsp;
import modelo.ContBDImpleCompEsp;

public class DataFactoryCompEsp {
	private static ContDatosCompEsp datos;
	
	public static ContDatosCompEsp getDatos() {
		if (datos == null) {
			datos = new ContBDImpleCompEsp();
		}
		return datos;
	}
}
