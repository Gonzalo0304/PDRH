package controlador;

import controlador.interfaces.ContDatosBusqPer;
import modelo.ContBDImpleBusqPer;

public class DataFactoryBusqPer {
	private static ContDatosBusqPer datos;
	
	public static ContDatosBusqPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqPer();
		}
		return datos;
	}
}
