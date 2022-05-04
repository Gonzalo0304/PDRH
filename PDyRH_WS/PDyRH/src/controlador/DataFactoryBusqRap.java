package controlador;

import controlador.interfaces.ContDatosBusqRap;
import modelo.ContBDImpleBusqRap;

public class DataFactoryBusqRap {
	private static ContDatosBusqRap datos;
	
	public static synchronized ContDatosBusqRap getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqRap();
		}
		return datos;
	}
}
