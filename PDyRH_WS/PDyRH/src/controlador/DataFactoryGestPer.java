package controlador;

import controlador.interfaces.ContDatosGestPer;
import modelo.ContBDImpleGestPer;

public class DataFactoryGestPer {
	private static ContDatosGestPer datos;
	
	public static ContDatosGestPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleGestPer();
		}
		return datos;
	}
}
