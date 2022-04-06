package modelo.clases;

import java.time.LocalDate;

public class Caso {
	// <--- Atributos --->
	private String codCaso;
	private String estado;
	private String nombre;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	
	// <--- Constructores --->
	public Caso() {
		super();
	}
	
	public Caso(String codCaso, String estado, String nombre, LocalDate fechaIni, LocalDate fechaFin) {
		super();
		this.codCaso = codCaso;
		this.estado = estado;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}
	
	public Caso(String codCaso, String estado, String nombre, LocalDate fechaIni) {
		super();
		this.codCaso = codCaso;
		this.estado = estado;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
	}
	
	// <--- Getters y Setters --->
	public String getCodCaso() {
		return codCaso;
	}

	public void setCodCaso(String codCaso) {
		this.codCaso = codCaso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
}
