package excepciones;

/**
 * Esta clase representa la excepcion que sirve para dar un aviso cuando ocurre un error en el programa
 * @author Equipo5
 *
 */
public class Excepciones extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * El constructor vacio
	 */
	public Excepciones() {
		super();
	}

	/**
	 * Esl constructor con parametros
	 * @param message Es el mensaje que lanzara cuando ocurra el error
	 */
	public Excepciones(String message) {
		super(message);
	}	

}
