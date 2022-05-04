package controlador;

import controlador.interfaces.ContDatosBusqCaso;
import modelo.ContBDImpleBusqCaso;

public class DataFactoryBusqCaso {
	private static ContDatosBusqCaso datos;
	
	public static synchronized ContDatosBusqCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqCaso();
		}
		return datos;
	}
}
