package controlador;

import controlador.interfaces.ContDatosBusqPer;
import modelo.ContBDImpleBusqPer;

/**
 * @author Equipo5
 *
 */
public class DataFactoryBusqPer {
	private static ContDatosBusqPer datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosBusqPer getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqPer();
		}
		return datos;
	}
}
