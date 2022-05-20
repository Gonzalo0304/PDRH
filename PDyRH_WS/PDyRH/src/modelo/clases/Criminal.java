package modelo.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa el Criminal que extiende de persona
 * @author Equipo5
 *
 */
public class Criminal extends Persona {
	// <--- Atributos --->
	/**
	 * Aqui guarda si esta prisionero o no
	 */
	private boolean prisionero;
	/**
	 * Las fechas de las veces que ha sido arrestado
	 */
	private List<LocalDate> fechasArresto;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio.
	 */
	public Criminal() {
		super();
		fechasArresto = new ArrayList<>();
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
	 * @param prisionero
	 * @param fechasArresto
	 */
	public Criminal(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			LocalDate fechaFal, boolean prisionero, ArrayList<LocalDate> fechasArresto) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaFal);
		this.prisionero = prisionero;
		this.fechasArresto = fechasArresto;
	}
	
	// <--- Getters y Setters --->
	public boolean isPrisionero() {
		return prisionero;
	}
	public void setPrisionero(boolean prisionero) {
		this.prisionero = prisionero;
	}
	public List<LocalDate> getFechasArresto() {
		return fechasArresto;
	}
	public void setFechasArresto(List<LocalDate> fechasArresto) {
		this.fechasArresto = fechasArresto;
	}
}
