package controlador;

import controlador.interfaces.ContDatosRH;
import modelo.ContBDImpleRH;

/**
 * @author Equipo5
 *
 */
public class DataFactoryRH {
	private static ContDatosRH datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosRH getDatos() {
		if (datos == null) {
			datos = new ContBDImpleRH();
		}
		return datos;
	}
}
