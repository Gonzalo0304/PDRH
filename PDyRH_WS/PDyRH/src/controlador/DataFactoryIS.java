package controlador;

import controlador.interfaces.ControladorDatosIS;
import modelo.ContBDImpleIS;

	/**
	 * @author Equipo5
	 *
	 */
	public class DataFactoryIS {
	private static ControladorDatosIS datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ControladorDatosIS getDatos() {
		if (datos == null) {
			datos = new ContBDImpleIS();
		}
		return datos;
	}
}
