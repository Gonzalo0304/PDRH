package modelo.clases;

public class Conocido {
	// <--- Atributos --->
	private String nomComp;
	private String dni1;
	private String dni2;
	private String relacion;
	
	// <--- Constructores --->
	public Conocido() {
		super();
	}

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
