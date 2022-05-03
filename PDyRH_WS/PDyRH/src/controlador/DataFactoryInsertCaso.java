package controlador;

import controlador.interfaces.ContDatosInsertCaso;
import modelo.ContBDImpleInsertCaso;

public class DataFactoryInsertCaso {
	private static ContDatosInsertCaso datos;
	
	public static synchronized ContDatosInsertCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleInsertCaso();
		}
		return datos;
	}
}
