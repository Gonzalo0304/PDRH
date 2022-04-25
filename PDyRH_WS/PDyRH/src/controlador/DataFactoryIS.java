package controlador;

import modelo.ContBDImpleIS;

	public class DataFactoryIS {
	private static ControladorDatosIS datos;
	
	public static synchronized ControladorDatosIS getDatos() {
		if (datos == null) {
			datos = new ContBDImpleIS();
		}
		return datos;
	}
}
