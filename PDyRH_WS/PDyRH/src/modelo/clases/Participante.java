package modelo.clases;

/**
 * Esta clase representa el parTicipante del caso
 * @author Equipo5
 *
 */
public class Participante {
	// <--- Atributos --->
	/**
	 * El nombre del participante
	 */
	private String nomComp;
	/**
	 * El dni de la persona
	 */
	private String dni;
	/**
	 * La implicacion que tiene con el caso
	 */
	private String implicacion;
	/**
	 * El codigo del caso
	 */
	private String codCaso;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public Participante() {
		super();
	}

	/**
	 * Constructor con parametros
	 * @param nomComp
	 * @param dni
	 * @param codCaso
	 * @param implicacion
	 */
	public Participante(String nomComp, String dni, String codCaso, String implicacion) {

		super();
		this.nomComp = nomComp;
		this.dni = dni;
		this.codCaso = codCaso;
		this.implicacion = implicacion;
		this.codCaso = codCaso;
	}
	
	public String getNomComp() {
		return nomComp;
	}
	
	public void setNomComp(String nomComp) {
		this.nomComp = nomComp;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getImplicacion() {
		return implicacion;
	}

	public void setImplicacion(String implicacion) {
		this.implicacion = implicacion;
	}

	public String getCodCaso() {
		return codCaso;
	}
	public void setCodCaso(String codCaso) {
		this.codCaso = codCaso;
	}
}
