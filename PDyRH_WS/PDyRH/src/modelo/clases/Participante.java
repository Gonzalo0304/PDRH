package modelo.clases;

public class Participante {
	// <--- Atributos --->
	private String dni;
	private String codCaso;
	private String implicacion;
	
	// <--- Constructores --->
	public Participante() {
		super();
	}

	public Participante(String dni, String codCaso, String implicacion) {
		super();
		this.dni = dni;
		this.codCaso = codCaso;
		this.implicacion = implicacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodCaso() {
		return codCaso;
	}

	public void setCodCaso(String codCaso) {
		this.codCaso = codCaso;
	}

	public String getImplicacion() {
		return implicacion;
	}

	public void setImplicacion(String implicacion) {
		this.implicacion = implicacion;
	}
	
}
