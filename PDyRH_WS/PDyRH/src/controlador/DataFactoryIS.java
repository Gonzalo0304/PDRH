package controlador;

import controlador.interfaces.ControladorDatosIS;
import modelo.ContBDImpleIS;

	public class DataFactoryIS {
	private static ControladorDatosIS datos;
	
	public static ControladorDatosIS getDatos() {
		if (datos == null) {
			datos = new ContBDImpleIS();
		}
		return datos;
	}
}
