package modelo.clases;

import java.time.LocalDate;

public class Persona {
	// <--- Atributos --->
	private String dni;
	private String nombre;
	private String apellido;
	private int[] telefonos;
	private String localidad;
	private LocalDate fechaNac;
	private LocalDate fechaFal;
	
	// <--- Constructores --->
	public Persona() {
		super();
	}
	
	public Persona(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			LocalDate fechaFal) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos = telefonos;
		this.localidad = localidad;
		this.fechaNac = fechaNac;
		this.fechaFal = fechaFal;
	}

	public Persona(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos = telefonos;
		this.localidad = localidad;
		this.fechaNac = fechaNac;
	}
	
	// <--- Getters y Setters --->
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(int[] telefonos) {
		this.telefonos = telefonos;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaFal() {
		return fechaFal;
	}

	public void setFechaFal(LocalDate fechaFal) {
		this.fechaFal = fechaFal;
	}
}
