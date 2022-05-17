package modelo.clases;

import java.time.LocalDate;

public class Banda {
	// <--- Atributos --->
	private String codBanda;
	private boolean organizada;
	private String nombre;
	private String ambito;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	
	// <--- Constructores --->
	public Banda() {
		super();
	}
	
	public Banda(String codBanda, boolean organizada, String nombre, String ambito, LocalDate fechaIni,
			LocalDate fechaFin) {
		super();
		this.codBanda = codBanda;
		this.organizada = organizada;
		this.nombre = nombre;
		this.ambito = ambito;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}
	
	public Banda(String codBanda, boolean organizada, String nombre, String ambito, LocalDate fechaIni) {
		super();
		this.codBanda = codBanda;
		this.organizada = organizada;
		this.nombre = nombre;
		this.ambito = ambito;
		this.fechaIni = fechaIni;
	}
	
	// <--- Getters y Setters --->
	public String getCodBanda() {
		return codBanda;
	}

	public void setCodBanda(String codBanda) {
		this.codBanda = codBanda;
	}

	public boolean isOrganizada() {
		return organizada;
	}

	public void setOrganizada(boolean organizada) {
		this.organizada = organizada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
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
