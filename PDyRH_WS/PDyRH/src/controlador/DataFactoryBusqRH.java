package controlador;

import controlador.interfaces.ContDatosBusqRH;
import modelo.ContBDImpleBusqRH;

public class DataFactoryBusqRH {
	private static ContDatosBusqRH datos;
	
	public static synchronized ContDatosBusqRH getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqRH();
		}
		return datos;
	}
}
