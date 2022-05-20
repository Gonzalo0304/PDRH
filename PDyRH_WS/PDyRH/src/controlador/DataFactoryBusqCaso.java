package controlador;

import controlador.interfaces.ContDatosBusqCaso;
import modelo.ContBDImpleBusqCaso;

/**
 * @author Equipo5
 *
 */
public class DataFactoryBusqCaso {
	private static ContDatosBusqCaso datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosBusqCaso getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqCaso();
		}
		return datos;
	}
}
