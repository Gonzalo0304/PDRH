package modelo.clases;

import java.time.LocalDate;

/**
 * Esta clase representa a la desaparecida que extiende de Persona
 * @author Equipo5
 *
 */
public class Desaparecida extends Persona {
	// <--- Atributos --->
	/**
	 * La fecha que ha desaparecido
	 */
	private LocalDate fechaDes;
	/**
	 * La ultima ubicacion que ha sido vista
	 */
	private String ultimaUbi;
	/**
	 * El genero de la persona
	 */
	private String genero;
	/**
	 * El tipo de pelo
	 */
	private String tipoPelo;
	/**
	 * El color de pelo
	 */
	private String colorPelo;
	/**
	 * El color de ojos 
	 */
	private String colorOjos;
	/**
	 * La altura
	 */
	private int altura;
	/**
	 * La especificaciones de la persona desaparecida
	 */
	private String especificaciones;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public Desaparecida() {
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
	 * @param fechaDes
	 * @param ultimaUbi
	 * @param genero
	 * @param tipoPelo
	 * @param colorPelo
	 * @param colorOjos
	 * @param altura
	 * @param especificaciones
	 */
	public Desaparecida(String dni, String nombre, String apellido, int[] telefonos, String localidad,
			LocalDate fechaNac, LocalDate fechaDes, String ultimaUbi, String genero, String tipoPelo,
			String colorPelo, String colorOjos, int altura, String especificaciones) {
		super(dni, nombre, apellido, telefonos, localidad, fechaNac, fechaDes);
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

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
}
