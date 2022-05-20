package controlador;

import controlador.interfaces.ContDatosGestPer;
import modelo.ContBDImpleGestPer;

/**
 * @author Equipo5
 *
 */
public class DataFactoryGestPer {
	private static ContDatosGestPer datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosGestPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleGestPer();
		}
		return datos;
	}
}
