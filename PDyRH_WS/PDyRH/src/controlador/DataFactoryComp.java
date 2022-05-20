package controlador;

import controlador.interfaces.ContDatosComp;
import modelo.ContBDImpleComp;

/**
 * @author Equipo5
 *
 */
public class DataFactoryComp {
	private static ContDatosComp datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosComp getDatos() {
		if (datos == null) {
			datos = new ContBDImpleComp();
		}
		return datos;
	}
}
