package modelo.clases;

public class Participante {
	// <--- Atributos --->
	private String dni;
	private String implicacion;
	
	// <--- Constructores --->
	public Participante() {
		super();
	}
	public Participante(String dni, String implicacion) {
		super();
		this.dni = dni;
		this.implicacion = implicacion;
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
}

