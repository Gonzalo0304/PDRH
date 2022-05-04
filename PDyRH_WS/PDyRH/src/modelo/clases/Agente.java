package modelo.clases;

import java.time.LocalDate;

public class Agente extends Persona {
	// <--- Atributos --->
	private String rango;
	private LocalDate inicioServ;
	private LocalDate finServ;
	
	// <--- Constructores --->
	public Agente() {
		super();
	}

	public Agente(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			LocalDate fechaFal, String rango, LocalDate inicioServ, LocalDate finServ) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaFal);
		this.rango = rango;
		this.inicioServ = inicioServ;
		this.finServ = finServ;
	}
	
	// <--- Getters y Setters --->
	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public LocalDate getInicioServ() {
		return inicioServ;
	}

	public void setInicioServ(LocalDate inicioServ) {
		this.inicioServ = inicioServ;
	}

	public LocalDate getFinServ() {
		return finServ;
	}

	public void setFinServ(LocalDate finServ) {
		this.finServ = finServ;
	}
	
	
}
