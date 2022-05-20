package controlador.interfaces;

/**
 * Esta clase representa la ventana controlador de datos de inicio de sesion. Para asegurase de que se ejecutan los metodos independientemente de la base de datos utilizada
 * @author Equipo5
 */
public interface ControladorIU {
	
	/**
	 * Método para separar la capa de presentación y de negocio
	 */
	public void conPresentacion();
}
