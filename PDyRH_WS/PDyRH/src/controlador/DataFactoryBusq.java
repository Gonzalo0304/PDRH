package controlador;

import modelo.ContBDImpleBusq;

public class DataFactoryBusq {
	private static ContDatosBusq datos;
	
	public static synchronized ContDatosBusq getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusq();
		}
		return datos;
	}
}

