package controlador;

import controlador.interfaces.ContDatosCompEsp;
import modelo.ContBDImpleCompEsp;

/**
 * @author Equipo5
 *
 */
public class DataFactoryCompEsp {
	private static ContDatosCompEsp datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosCompEsp getDatos() {
		if (datos == null) {
			datos = new ContBDImpleCompEsp();
		}
		return datos;
	}
}
