package controlador;

import controlador.interfaces.ContDatosBusq;
import modelo.ContBDImpleBusq;

public class DataFactoryBusq {
	private static ContDatosBusq datos;
	
	public static ContDatosBusq getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusq();
		}
		return datos;
	}
}
