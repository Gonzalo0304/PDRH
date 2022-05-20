package modelo.clases;

import java.time.LocalDate;

/**
 * Esta clase representa al Agente que extiende de la clase Persona
 * @author Elias
 *
 */
public class Agente extends Persona {
	// <--- Atributos --->
	/**
	 * El rango es la clasificacion del agente  
	 */
	private int rango;
	/**
	 * El inicio de servicio es la fecha de cuando empezo.
	 */
	private LocalDate inicioServ;
	/**
	 * El fin de servicio es la fecha de cuando finalizo.
	 */
	private LocalDate finServ;
	
	// <--- Constructores --->
	/**
	 * Este es el constructor vacio
	 */
	public Agente() {
		super();
	}

	/**
	 * El constructor con parametros
	 * @param dni: El dni de la persona
	 * @param nombre: El nombre de la persona 
	 * @param apellido: El apellido de la persona
	 * @param telefonos: El numero de telefono de la persona
	 * @param localidad: El lugar donde vive
	 * @param fechaNac: La fecha de nacimiento
	 * @param fechaFal: La fecha de fallecimiento
	 * @param rango
	 * @param inicioServ
	 * @param finServ
	 */
	public Agente(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			LocalDate fechaFal, int rango, LocalDate inicioServ, LocalDate finServ) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaFal);
		this.rango = rango;
		this.inicioServ = inicioServ;
		this.finServ = finServ;
	}
	
	// <--- Getters y Setters --->
	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
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
