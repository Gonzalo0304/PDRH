package controlador;

import controlador.interfaces.ContDatosBusq;
import modelo.ContBDImpleBusq;

/**
 * @author Equipo5
 *
 */
public class DataFactoryBusq {
	private static ContDatosBusq datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosBusq getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusq();
		}
		return datos;
	}
}
