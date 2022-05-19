package modelo.clases;

/**
 * Esta clase representa 
 * @author 1dam
 *
 */
public class Participante {
	// <--- Atributos --->
	/**
	 * 
	 */
	private String nomComp;
	/**
	 * 
	 */
	private String dni;
	/**
	 * 
	 */
	private String implicacion;
	/**
	 * 
	 */
	private String codCaso;
	
	// <--- Constructores --->
	/**
	 * 
	 */
	public Participante() {
		super();
	}

	/**
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
