package vista;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JDialog;

import controlador.DataFactoryBusqRap;
import controlador.interfaces.ContDatosBusqRap;
import modelo.clases.Persona;

public class VBusRapida extends JDialog implements ContDatosBusqRap {

	private static final long serialVersionUID = 1L;

	ContDatosBusqRap datos = DataFactoryBusqRap.getDatos();
	
	public VBusRapida(VIniciarSesion padre, boolean modal, String[] info) {
		super(padre);
		this.setModal(modal);
		setTitle("Busqueda Rapida");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
	}

	@Override
	public Map<String, Persona> obtenerPersonas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
