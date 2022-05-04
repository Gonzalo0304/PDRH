package modelo.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Criminal extends Persona {
	// <--- Atributos --->
	private boolean prisionero;
	private List<LocalDate> fechasArresto;
	
	// <--- Constructores --->
	public Criminal() {
		super();
		fechasArresto = new ArrayList<>();
	}
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
