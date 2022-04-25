package modelo;

import controlador.ControladorIU;
import vista.VIniciarSesion;

public class ContVentImpleIU implements ControladorIU {
	@Override
	public void conPresentacion() {
		VIniciarSesion ventanaIS = new VIniciarSesion();
		ventanaIS.setVisible(true);
	}

}
