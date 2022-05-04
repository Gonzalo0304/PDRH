package modelo.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Desaparecida extends Persona {
	// <--- Atributos --->
	private LocalDate fechaDes;
	private String ultimaUbi;
	private String genero;
	private String tipoPelo;
	private String colorPelo;
	private String colorOjos;
	private float altura;
	private String especificaciones;
	
	// <--- Constructores --->
	public Desaparecida() {
	}

	public Desaparecida(String dni, String nombre, String apellido, int[] telefonos, String localidad,
			LocalDate fechaNac, LocalDate fechaFal, LocalDate fechaDes, String ultimaUbi, String genero,
			String tipoPelo, String colorPelo, String colorOjos, float altura, String especificaciones) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaFal);
		this.fechaDes = fechaDes;
		this.ultimaUbi = ultimaUbi;
		this.genero = genero;
		this.tipoPelo = tipoPelo;
		this.colorPelo = colorPelo;
		this.colorOjos = colorOjos;
		this.altura = altura;
		this.especificaciones = especificaciones;
	}

	public Desaparecida(String dni, String nombre, String apellido, int[] telefonos, String localidad,
			LocalDate fechaNac, LocalDate fechaDes, String ultimaUbi, String genero, String tipoPelo,
			String colorPelo, String colorOjos, float altura, String especificaciones) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac);
		this.fechaDes = fechaDes;
		this.ultimaUbi = ultimaUbi;
		this.genero = genero;
		this.tipoPelo = tipoPelo;
		this.colorPelo = colorPelo;
		this.colorOjos = colorOjos;
		this.altura = altura;
		this.especificaciones = especificaciones;
	}
	
	// <--- Getters y Setters --->
	public LocalDate getFechaDes() {
		return fechaDes;
	}

	public void setFechaDes(LocalDate localDate) {
		this.fechaDes = localDate;
	}

	public String getUltimaUbi() {
		return ultimaUbi;
	}

	public void setUltimaUbi(String ultimaUbi) {
		this.ultimaUbi = ultimaUbi;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
}
