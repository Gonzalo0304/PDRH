package modelo.clases;

public class Conocido {
	// <--- Atributos --->
	private String dni;
	private String relacion;
	
	// <--- Constructores --->
	public Conocido() {
		super();
	}
	public Conocido(String dni, String relacion) {
		super();
		this.dni = dni;
		this.relacion = relacion;
	}
	
	// <--- Getters y Setters --->
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
}
