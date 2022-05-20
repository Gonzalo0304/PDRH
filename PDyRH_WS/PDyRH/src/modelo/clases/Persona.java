package modelo.clases;

import java.time.LocalDate;

/**
 * Esta clase representa a la Persona
 * @author Equipo5
 *
 */
public class Persona {
	// <--- Atributos --->
	/**
	 * El dni de la persona
	 */
	private String dni;
	/**
	 * El nombre de la persona
	 */
	private String nombre;
	/**
	 * El apellido
	 */
	private String apellido;
	/**
	 * La persona puede tener dos telefonos
	 */
	private int[] telefonos;
	/**
	 * La localidad donde vive
	 */
	private String localidad;
	/**
	 * La fecha de nacimiento
	 */
	private LocalDate fechaNac;
	/**
	 * La fecha de fallecimiento
	 */
	private LocalDate fechaFal;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public Persona() {
		super();
	}
	
	/**
	 * Constructor con parametros
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param telefonos
	 * @param localidad
	 * @param fechaNac
	 * @param fechaFal
	 */
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
