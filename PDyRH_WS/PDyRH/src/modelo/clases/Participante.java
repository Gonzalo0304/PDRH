package modelo.clases;

public class Participante {
	// <--- Atributos --->
	private String dni;
	private String implicacion;
	private String codCaso;
	
	// <--- Constructores --->
	public Participante() {
		super();
	}
	public Participante(String dni, String implicacion, String codCaso) {
		super();
		this.dni = dni;
		this.implicacion = implicacion;
		this.codCaso = codCaso;
	}
	
	// <--- Getters y Setters --->
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
