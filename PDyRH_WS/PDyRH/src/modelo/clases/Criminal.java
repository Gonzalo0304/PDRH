package modelo.clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Criminal extends Persona {
	// <--- Atributos --->
	private boolean prisionero;
	private ArrayList<LocalDate> fechasArresto;
	
	// <--- Constructores --->
	public Criminal() {
		super();
	}
	public Criminal(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			LocalDate fechaFal, boolean prisionero, ArrayList<LocalDate> fechasArresto) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaFal);
		this.prisionero = prisionero;
		this.fechasArresto = fechasArresto;
	}
	public Criminal(String dni, String nombre, String apellido, int[] telefonos, String localidad, LocalDate fechaNac,
			boolean prisionero, ArrayList<LocalDate> fechasArresto) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac);
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
	public ArrayList<LocalDate> getFechasArresto() {
		return fechasArresto;
	}
	public void setFechasArresto(ArrayList<LocalDate> fechasArresto) {
		this.fechasArresto = fechasArresto;
	}
}
