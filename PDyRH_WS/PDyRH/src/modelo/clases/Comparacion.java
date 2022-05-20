package modelo.clases;

/**
 * Esta clase representa la comparacion de la persona desaparecida y el resto humano
 * @author Elias
 *
 */
public class Comparacion {
	// <--- Atributos --->
	/**
	 * El dni es la identificacion de la persona
	 */
	private String dni;
	/**
	 * El codigo del resto es la identificaion del resto humano.
	 */
	private String codResto;
	/**
	 * El porcentaje es la coincidencia que hay entre un resto humano y una desaparecida.
	 */
	private float porcentaje;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio.
	 */
	public Comparacion() {
		super();
	}
	/**
	 * Constructor con parametros.
	 * @param dni
	 * @param codResto
	 * @param porcentaje
	 */
	public Comparacion(String dni, String codResto, float porcentaje) {
		super();
		this.dni = dni;
		this.codResto = codResto;
		this.porcentaje = porcentaje;
	}
	
	// <--- Getters y Setters --->
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodResto() {
		return codResto;
	}
	public void setCodResto(String codResto) {
		this.codResto = codResto;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
}
