package controlador;

import controlador.interfaces.ContDatosGestCaso;
import modelo.ContBDImpleGestCaso;

public class DataFactoryGestCaso {
	private static ContDatosGestCaso datos;
	
	public static synchronized ContDatosGestCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleGestCaso();
		}
		return datos;
	}
}
