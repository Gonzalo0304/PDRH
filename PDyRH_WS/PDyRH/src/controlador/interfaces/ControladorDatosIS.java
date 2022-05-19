package controlador.interfaces;

/**
 * Esta clase representa la ventana controlador de datos de inicio de sesion. Para asegurase de que se ejecutan los metodos independientemente de la base de datos utilizada
 * @author Gonzalo
 */
public interface ControladorDatosIS {
	/**
	 * Comprueba las credenciales de inicio de sesion
	 * @param usuario carga los datos de usuario.
	 * @return
	 */
	public String[] comprobarCredenciales(String usuario);
}
