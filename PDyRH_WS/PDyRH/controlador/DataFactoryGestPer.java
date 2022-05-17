package controlador;

import controlador.interfaces.ContDatosGestPer;
import modelo.ContBDImpleGestPer;

public class DataFactoryGestPer {
	private static ContDatosGestPer datos;
	
	public static synchronized ContDatosGestPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleGestPer();
		}
		return datos;
	}
}
