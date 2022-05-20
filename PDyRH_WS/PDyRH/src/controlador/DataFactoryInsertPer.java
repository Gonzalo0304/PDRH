package controlador;

import controlador.interfaces.ContDatosInsertPer;
import modelo.ContBDImpleInsertPer;

/**
 * @author Equipo5
 *
 */
public class DataFactoryInsertPer {
	private static ContDatosInsertPer datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosInsertPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleInsertPer();
		}
		return datos;
	}
}
