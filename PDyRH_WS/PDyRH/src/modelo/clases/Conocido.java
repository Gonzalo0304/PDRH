package modelo.clases;

/**
 * Esta clase representa los conocidos de una persona
 * @author Equipo5
 *
 */
public class Conocido {
	// <--- Atributos --->
	/**
	 * El nombre de la persona conocida
	 */
	private String nomComp;
	/**
	 * El dni de una persona conocida
	 */
	private String dni1;
	/**
	 * El dni de la otra persona
	 */
	private String dni2;
	/**
	 * Descripcion de la relacion entre los dos 
	 */
	private String relacion;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public Conocido() {
		super();
	}

	/**
	 * Constructor con parametros
	 * @param nomComp
	 * @param dni1
	 * @param dni2
	 * @param relacion
	 */
	public Conocido(String nomComp, String dni1, String dni2, String relacion) {
		super();
		this.nomComp = nomComp;
		this.dni1 = dni1;
		this.dni2 = dni2;
		this.relacion = relacion;
	}

	
	// <--- Getters y Setters --->
	public String getNomComp() {
		return nomComp;
	}
	public void setNomComp(String nomComp) {
		this.nomComp = nomComp;
	}
	public String getDni1() {
		return dni1;
	}
	public void setDni1(String dni1) {
		this.dni1 = dni1;
	}

	public String getDni2() {
		return dni2;
	}

	public void setDni2(String dni2) {
		this.dni2 = dni2;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
	
}
