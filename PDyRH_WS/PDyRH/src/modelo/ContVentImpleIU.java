package modelo;

import controlador.interfaces.ControladorIU;
import vista.VIniciarSesion;
/**
 * Esta clase representa la ventana de Implementacion de Inicio de sesion. Se utiliza para crear la ventana de Inicio de sesión mediante el método de su respectiva interfaz.
 * @author Equipo5
 */
public class ContVentImpleIU implements ControladorIU {
	@Override
	public void conPresentacion() {
		VIniciarSesion ventanaIS = new VIniciarSesion();
		ventanaIS.setVisible(true);
	}

}
