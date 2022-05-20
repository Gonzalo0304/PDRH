package controlador;

import controlador.interfaces.ContDatosInsertCaso;
import modelo.ContBDImpleInsertCaso;

/**
 * @author Equipo5
 *
 */
public class DataFactoryInsertCaso {
	private static ContDatosInsertCaso datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosInsertCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleInsertCaso();
		}
		return datos;
	}
}
