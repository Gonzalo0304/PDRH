package controlador;

import modelo.ContBDImpleInsertPer;

public class DataFactoryInsertPer {
	private static ContDatosInsertPer datos;
	
	public static synchronized ContDatosInsertPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleInsertPer();
		}
		return datos;
	}
}
