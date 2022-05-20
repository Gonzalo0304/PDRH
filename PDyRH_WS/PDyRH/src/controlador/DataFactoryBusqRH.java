package controlador;

import controlador.interfaces.ContDatosBusqRH;
import modelo.ContBDImpleBusqRH;

/**
 * @author Equipo5
 *
 */
public class DataFactoryBusqRH {
	private static ContDatosBusqRH datos;
	
	/**
	 * @return devuelve los datos de la base de datos asegurandose de que solo se inicialice una vez.
	 */
	public static ContDatosBusqRH getDatos() {
		if (datos == null) {
			datos = new ContBDImpleBusqRH();
		}
		return datos;
	}
}
