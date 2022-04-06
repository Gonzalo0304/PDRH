package controlador;

import modelo.ControladorBDImplementacion;

public class DataFactory {
	private static ControladorDatos datos;
	
	public static synchronized ControladorDatos getDatos() {
		if (datos == null) {
			datos = new ControladorBDImplementacion();
		}
		return datos;
	}
}
