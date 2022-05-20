package controlador;

import controlador.interfaces.ContDatosComp;
import modelo.ContBDImpleComp;

public class DataFactoryComp {
	private static ContDatosComp datos;
	
	public static ContDatosComp getDatos() {
		if (datos == null) {
			datos = new ContBDImpleComp();
		}
		return datos;
	}
}
