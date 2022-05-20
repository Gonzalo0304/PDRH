package controlador;

import controlador.interfaces.ContDatosGestCaso;
import modelo.ContBDImpleGestCaso;

/**
 * @author Equipo5
 *
 */
public class DataFactoryGestCaso {
	private static ContDatosGestCaso datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosGestCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleGestCaso();
		}
		return datos;
	}
}
