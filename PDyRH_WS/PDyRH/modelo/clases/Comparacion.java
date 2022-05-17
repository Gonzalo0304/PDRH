package modelo.clases;

public class Comparacion {
	// <--- Atributos --->
	private String dni;
	private String codResto;
	private float porcentaje;
	
	// <--- Constructores --->
	public Comparacion() {
		super();
	}
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
